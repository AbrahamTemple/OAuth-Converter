package com.cloud.vongoauth.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.26
 * @GitHub https://github.com/AbrahamTemple/
 * @description: Shiro基础配置
 */
@Configuration
public class ShiroConfig {

    /**
     * 设置securityManager
     * @param webSecurityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean filterFactoryBean(@Qualifier("WSM") DefaultWebSecurityManager webSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(webSecurityManager);
        return bean;
    }

    /**
     * 设置userRealm
     * @param userRealm
     * @return
     */
    @Bean(name = "WSM")
    public DefaultWebSecurityManager webSecurityManager(@Qualifier("uRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 自定义认证
     * @return
     */
    @Bean(name = "uRealm")
    public UserRealm userRealm() {
        return new UserRealm();
    }
}
