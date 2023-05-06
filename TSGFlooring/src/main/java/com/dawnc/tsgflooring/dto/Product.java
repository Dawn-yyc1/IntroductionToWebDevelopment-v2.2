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
public class Product {
    private String materialType; 
    private BigDecimal costPerSqFt;
    private BigDecimal laborCostPerSqFt;

    public Product(String materialType){
        this.materialType = materialType;
    }
    public Product(String materialType, BigDecimal costPerSqFt, BigDecimal laborCostPerSqFt) {
        this.materialType = materialType;
        this.costPerSqFt = costPerSqFt;
        this.laborCostPerSqFt = laborCostPerSqFt;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public BigDecimal getCostPerSqFt() {
        return costPerSqFt;
    }

    public void setCostPerSqFt(BigDecimal costPerSqFt) {
        this.costPerSqFt = costPerSqFt;
    }

    public BigDecimal getLaborCostPerSqFt() {
        return laborCostPerSqFt;
    }

    public void setLaborCostPerSqFt(BigDecimal laborCostPerSqFt) {
        this.laborCostPerSqFt = laborCostPerSqFt;
    }
    
}
