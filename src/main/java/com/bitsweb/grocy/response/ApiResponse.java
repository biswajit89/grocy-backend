/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitsweb.grocy.response;

/**
 *
 * @author Biswajit
 */
public class ApiResponse {
    private boolean success;
    private String message;
    private Object response;

    public ApiResponse(boolean success, String message, Object response) {
        this.success = success;
        this.message = message;
        this.response = response;
    }
    
    
}
