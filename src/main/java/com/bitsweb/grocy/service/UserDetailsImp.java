/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitsweb.grocy.service;

import com.bitsweb.grocy.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Biswajit
 */
public class UserDetailsImp implements UserDetailsService {

    @Autowired
    private final UserRepository repository;

    public UserDetailsImp(UserRepository repository) {
        this.repository = repository;
    }
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return repository.findByUsername(name).orElseThrow(() -> new UsernameNotFoundException("User Not found"));
    }
    
}
