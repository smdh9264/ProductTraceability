package com.pt.ptcenteruser.security;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author wl
 * @date 2020/5/19
 */
//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/user/info/*").permitAll()
//                .anyRequest().authenticated()
//        .and().csrf().disable();
//    }

//    /**
//     * 通过这个Bean，去远程调用认证服务器，验token
//     * @return
//     */
//    @Primary
//    @Bean
//    public ResourceServerTokenServices tokenServices(){
//        RemoteTokenServices tokenServices = new RemoteTokenServices();
//        tokenServices.setClientId("user-client");//在认证服务器配置的，订单服务的clientId
//        tokenServices.setClientSecret("secret");//在认证服务器配置的，订单服务的ClientSecret
//        tokenServices.setCheckTokenEndpointUrl("http://localhost:9001/oauth/check_token");
//        return tokenServices;
//    }
//
//
//    /**
//     * 要认证跟用户相关的信息，一般用 AuthenticationManager
//     * 覆盖这个方法，可以将AuthenticationManager暴露为一个Bean
//     *
//     * @return
//     * @throws Exception
//     */
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        OAuth2AuthenticationManager authenticationManager = new OAuth2AuthenticationManager();
//        authenticationManager.setTokenServices(tokenServices());//设置为自定义的TokenServices，去校验令牌
//        return authenticationManager;
//    }
}
