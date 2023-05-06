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
public class TsgDaoException extends Exception{
    
    public TsgDaoException(String message) {
        super(message); 
    }
    public TsgDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
