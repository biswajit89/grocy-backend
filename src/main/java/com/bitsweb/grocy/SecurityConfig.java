/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitsweb.grocy;

import com.bitsweb.grocy.filter.JwtFilter;
import com.bitsweb.grocy.service.UserDetailsImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author Biswajit
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailsImp userDetailsImp;
    private final JwtFilter jwtFilter;

    public SecurityConfig(UserDetailsImp userDetailsImp, JwtFilter jwtFilter) {
        this.userDetailsImp = userDetailsImp;
        this.jwtFilter = jwtFilter;
    }
    
    @Bean
    public SecurityFilterChain securityFitlerChain(HttpSecurity http) throws Exception {
        return 
                http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        req -> req.requestMatchers("/login/**", "/signup/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                        .userDetailsService(userDetailsImp)
                        .sessionManagement(session -> session
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .addFilterBefore(jwtFilter, jwtFilter.getClass())
                        .build();
                
                
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean 
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
