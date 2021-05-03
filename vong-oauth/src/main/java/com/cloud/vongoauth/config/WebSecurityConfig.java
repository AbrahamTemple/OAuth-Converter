package com.cloud.vongoauth.config;

import com.cloud.vongoauth.bean.MySuccessHandler;
import com.cloud.vongoauth.data.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.3
 * @GitHub https://github.com/AbrahamTemple/
 * @description: SpringSecurity请求权限拦截
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // 引入自定义userDetails
    @Resource
    MyUserDetailsService myUserDetailsService;

    @Resource
    MySuccessHandler mySuccessHandler;

    /**
     * 加密Security登录密码
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
        //return NoOpPasswordEncoder.getInstance(); // 不对密码进行加密
    }
    @Resource
    BCryptPasswordEncoder passwordEncoder;

    /**
     * 通过http对象配置具体的认证规则、路由权限规则
     *  这里用http对象代替xm配置，注意这里每个and()之间的配置都相当于原来xml中一个标签包含的配置。
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin()// 使用默认的表单登录
//                .loginPage()
//                .loginProcessingUrl("http://localhost:8077/o/pass")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(mySuccessHandler)
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/*","/o/pass","/o/code","/o/code/get","/o/info")
                .permitAll()
                .anyRequest()
                .authenticated(); //除此之外全部拦截
    }

    /**
     * 用户认证规则，即用户传递何种信息才可以登录
     *  myUserDetailsService.loadUserByUsername 通过传入username，返回我们的user数据，
     *  passwordEncoder 会对user数据中的password进行BCrypt算法加密。
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
    }

//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("u1").password(new BCryptPasswordEncoder().encode("123")).authorities("USER").build());
//        return manager;
//    }


    /**
     * 忽略拦截check_token请求，以便可以认证
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/oauth/check_token");
    }

    /**
     * 配置密码模式Bean
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
