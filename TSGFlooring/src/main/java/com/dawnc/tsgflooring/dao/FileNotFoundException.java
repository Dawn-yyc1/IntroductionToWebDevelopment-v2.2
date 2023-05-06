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
public class FileNotFoundException extends Exception {
    
    public FileNotFoundException(String message){
        super(message);
    }
    
    public FileNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
