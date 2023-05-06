/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawnc.tsgflooring.ui;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author pisce
 */
public interface UserIO {
    
    void print(String message);
    
    void printf(String messsage);
    
    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);
    
    public BigDecimal printBigDecimal (String prompt, BigDecimal message);
    
    public BigDecimal readBigDecimalArea (String prompt);

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);

    String readStringNoEmpties(String prompt);
    
    String readString(String prompt);
            
    LocalDate readDate(String prompt);
    
    LocalDate readFutureDate(String prompt);
    
}

