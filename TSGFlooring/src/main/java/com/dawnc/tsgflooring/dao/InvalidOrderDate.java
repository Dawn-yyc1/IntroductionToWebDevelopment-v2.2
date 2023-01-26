/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawnc.tsgflooring.dao;

/**
 *
 * @author pisce
 */
public class InvalidOrderDate extends Exception {
    
    public InvalidOrderDate(String message){
        super(message);
    }
    
    public InvalidOrderDate(String message, Throwable cause) {
        super(message, cause);
    }
}
