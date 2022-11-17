package com.gabrielle.prontoar.security;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.GET, "/api/v1/doctors").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/doctors").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/doctors/login").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/admin/login").permitAll()
                .anyRequest().authenticated().and().cors();

        httpSecurity.addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
