/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitsweb.grocy.service;

import com.bitsweb.grocy.model.User;
import com.bitsweb.grocy.model.UserRepository;
import com.bitsweb.grocy.response.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Biswajit
 */
public class AuthenticationService {
    
    @Autowired
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }
    
    public AuthenticationResponse register(User request) {
        
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        request = userRepository.save(request);
        String token = jwtService.generateToken(request);
        return new AuthenticationResponse(token);
    }
}
