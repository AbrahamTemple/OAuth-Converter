package com.cloud.vongoauth.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.cloud.vongoauth.data.MyUserDetailsService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.4
 * @GitHub https://github.com/AbrahamTemple/
 * @description: 认证服务器基本配置
 */
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    /**
     * 使用druid连接池
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource dataSourceConfig()  {
        //return DataSourceBuilder.create().build() 默认jdbc的数据源
        return new DruidDataSource();
    }

    /**
     * 保存令牌
     * @return OAuth2令牌的持久性接口
     */
    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSourceConfig());
    }

    /**
     * 获取client子系统数据
     * @return 提供有关OAuth2客户端详细信息的服务
     */
    @Bean
    public ClientDetailsService jdbcClientDetails() {
        return new JdbcClientDetailsService(dataSourceConfig());
    }

    /**
     * 实现令牌服务实现的转换器接口，该接口将身份验证数据存储在令牌内
     * @return 转换器
     */
    @Bean
    public DefaultAccessTokenConverter defaultAccessTokenConverter(){
        DefaultAccessTokenConverter converter = new DefaultAccessTokenConverter();
        DefaultUserAuthenticationConverter userConverter = new DefaultUserAuthenticationConverter();
        userConverter.setUserDetailsService(new MyUserDetailsService());
//        userConverter.convertUserAuthentication()
        converter.setUserTokenConverter(userConverter);
        return converter;
    }


    /**
     * 设置令牌
     * @param endpoints 配置授权服务器端点的属性和增强功能
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore())
                .authenticationManager(new OAuth2AuthenticationManager())//密码授予的AuthenticationManager
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.GET)
                .userDetailsService(new MyUserDetailsService())
                .accessTokenConverter(defaultAccessTokenConverter());//依照token获取当前登录用户的信息
    }

    /**
     * 设置client
     * @param clients 提供有关OAuth2客户端详细信息服务的配置
     * @throws Exception 数据库连接异常
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(jdbcClientDetails());
    }

    /**
     * 允许客户端发送表单来进行权限认证来获取令牌
     * 只允许认证的客户端，比如网关服务才可以获取和校验token
     * @param security 安全认证的配置
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.allowFormAuthenticationForClients()
                .checkTokenAccess("isAuthenticated()")
                .tokenKeyAccess("isAuthenticated()");
    }

}
