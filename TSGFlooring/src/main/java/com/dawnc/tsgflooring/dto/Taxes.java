/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawnc.tsgflooring.dto;

import java.math.BigDecimal;

/**
 *
 * @author pisce
 */
public class Taxes {
    private String stateAbreviation; 
    private String stateName;
    private BigDecimal taxRate;  
    
    public Taxes(String stateAbreviation){
            this.stateAbreviation = stateAbreviation;
    }

    public Taxes(String stateAbreviation, String stateName, BigDecimal taxRate) {
        this.stateAbreviation = stateAbreviation;
        this.stateName = stateName;
        this.taxRate = taxRate;
    }


    public String getStateAbreviation() {
        return stateAbreviation;
    }

    public void setStateAbreviation(String stateAbreviation) {
        this.stateAbreviation = stateAbreviation;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

}
