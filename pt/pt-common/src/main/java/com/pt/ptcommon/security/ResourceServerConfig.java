package com.pt.ptcommon.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author wl
 */
@Configuration
@EnableResourceServer
@ComponentScan("com.pt.ptcommon")
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    protected RemoteTokenServices remoteTokenServices;



    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user/info/**").permitAll()
                .anyRequest().authenticated();
    }

    @Override
    @CrossOrigin
    public void configure(ResourceServerSecurityConfigurer resources) {
        DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();
        UserAuthenticationConverter userTokenConverter = new CustomUserAuthenticationConverter();
        accessTokenConverter.setUserTokenConverter(userTokenConverter);
        remoteTokenServices.setAccessTokenConverter(accessTokenConverter);
        resources
                .tokenServices(remoteTokenServices);
    }

}
