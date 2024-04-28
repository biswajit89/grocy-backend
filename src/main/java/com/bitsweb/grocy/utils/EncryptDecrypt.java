/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitsweb.grocy.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Biswajit
 */
public class EncryptDecrypt {
    
    public static String encrypt(String input) {
         try {
             BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
             return encode.encode(input);
         } catch(Exception e) {
             e.printStackTrace();
         }
         return input;
    }
    
}
