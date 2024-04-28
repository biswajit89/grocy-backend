/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitsweb.grocy.controller;

import com.bitsweb.grocy.model.User;
import com.bitsweb.grocy.response.AuthenticationResponse;
import com.bitsweb.grocy.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Biswajit
 */
@RestController
public class AuthenticationController {
    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }
    
    
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody User request) {
      return ResponseEntity.ok(authService.register(request));
      
    }
    
     @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody User request) {
      return ResponseEntity.ok(authService.register(request));
      
    }
}
