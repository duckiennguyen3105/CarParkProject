package com.fsoft.carparkproject.config;



import com.fsoft.carparkproject.service.Impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService employeeService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(employeeService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/employee").hasRole("USER")
                .antMatchers("/**")
                .permitAll()
                .anyRequest()
                .authenticated().and().formLogin();
    }
    
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider impl = new DaoAuthenticationProvider();
        impl.setUserDetailsService(employeeService);
        impl.setHideUserNotFoundExceptions(false);
        return impl;
    }
    
    @Bean
    public PasswordEncoder  getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}
