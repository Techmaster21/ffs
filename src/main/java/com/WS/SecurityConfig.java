package com.WS;

import com.WS.Config.SHA256PasswordEncoder;
import com.WS.Config.StatelessAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String AUTHORIZED_ROLE = "authorizedRoleName";

    private final UserDetailsService userService;
    private final StatelessAuthenticationFilter statelessAuthenticationFilter;

    private SHA256PasswordEncoder sha256PasswordEncoder;

    @Autowired
    public SecurityConfig(UserDetailsService userService, StatelessAuthenticationFilter statelessAuthenticationFilter, SHA256PasswordEncoder sha256PasswordEncoder) {
        super(true);
        this.userService = userService;
        this.statelessAuthenticationFilter = statelessAuthenticationFilter;
        this.sha256PasswordEncoder = sha256PasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // we use jwt so that we can disable csrf protection
        http.csrf().disable();
        http.cors().disable();

        http
                .exceptionHandling().and()
                .anonymous().and()
                .servletApi().and()
                .headers().cacheControl()
        ;

        http.authorizeRequests()
                .antMatchers(HttpMethod.POST,"/api/account/*").permitAll();
                //.anyRequest().authenticated();
                //.antMatchers("/*").permitAll()
//                .and()
//                .exceptionHandling()
//                .authenticationEntryPoint(new BasicAuthenticationEntryPoint());

        http.addFilterBefore(statelessAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * Prevent StatelessAuthenticationFilter will be added to Spring Boot filter chain.
     * Only Spring Security must use it.
     */
    @Bean
    public FilterRegistrationBean registration(StatelessAuthenticationFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(sha256PasswordEncoder);
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userService;
    }

}