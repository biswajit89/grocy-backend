/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitsweb.grocy.controller;

import com.bitsweb.grocy.model.User;
import com.bitsweb.grocy.model.UserRepository;
import com.bitsweb.grocy.response.ApiResponse;
import com.bitsweb.grocy.utils.EncryptDecrypt;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.Event.ID;

/**
 *
 * @author Biswajit
 */
@RestController
@RequestMapping(path="/user")
public class UserController {
    
    @Autowired
    private UserRepository userepository;
  
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> addUser(@RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            user.setPassword(EncryptDecrypt.encrypt(user.getPassword()));
            userepository.save(user);
            ApiResponse response = new ApiResponse(true, "user added", user);
            return new ResponseEntity<>(response, headers, HttpStatus.OK);
        } catch(Exception e) {
            System.out.println(e);
            return new ResponseEntity<>("Error", headers, HttpStatus.BAD_REQUEST);
        }
        
    }
    
    
    @GetMapping("/getall")
    private List<User> getUser() {
        return userepository.findAll();
    }
    
    @GetMapping("/getuserbyid/{id}")
    private Optional<User> getUserByid(@PathVariable("id") Integer id) {
        return userepository.findById(id);
    }
    
    @GetMapping("/getuserbyname/{name}")
    private List<User> getUserByName(@PathVariable("name") String name) {
        return userepository.findByName(name);
    }
    
}
