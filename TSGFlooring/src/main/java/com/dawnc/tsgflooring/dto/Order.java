/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawnc.tsgflooring.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author pisce
 */
public class Order {
    private LocalDate orderDate;
    private int orderNumber;
    private String clientName, state, productType;
    private Product product;
    private Taxes taxes;
    private BigDecimal taxRate; //taxRate by State
    private BigDecimal area;
    private BigDecimal materialCost, laborCost;
    private BigDecimal laborCostPerSqFt, materialCostPerSpFt, costPerSqFt;
    private BigDecimal totalTax;
    private BigDecimal total;

   
    public Order(String clientName, String state, String productType, BigDecimal area) {
        this.clientName = clientName;
        this.state = state;
        this.productType = productType;
        this.area = area;
    }
    
    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    public Order(LocalDate orderDate, String clientName, Product product, 
        Taxes taxes, BigDecimal area) {
        this.productType = product.getMaterialType();
        this.state = taxes.getStateAbreviation();
        this.orderDate = orderDate;
        this.clientName = clientName;
        this.product = product;
        this.taxes = taxes;
        this.area = area;
    }   

    public Order(BigDecimal materialCost, BigDecimal laborCost, BigDecimal totalTax, BigDecimal total) {
        this.materialCost = materialCost;
        this.laborCost = laborCost;
        this.totalTax = totalTax;
        this.total = total;
    }

    public Order(LocalDate orderDate, int orderNumber) {
        this.orderDate = orderDate;
        this.orderNumber = orderNumber;
    }

    public Order(LocalDate orderDate, int orderNumber, String clientName, 
            String state, String productType, BigDecimal area) {
        this.orderDate = orderDate;
        this.orderNumber = orderNumber;
        this.clientName = clientName;
        this.state = state;
        this.productType = productType;
        this.area = area;
    }
        
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getCostPerSqFt() {
        return costPerSqFt;
    }

    public void setCostPerSqFt(BigDecimal costPerSqFt) {
        this.costPerSqFt = costPerSqFt;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getLaborCostPerSqFt() {
        return laborCostPerSqFt;
    }

    public void setLaborCostPerSqFt(BigDecimal laborCostPerSqFt) {
        this.laborCostPerSqFt = laborCostPerSqFt;
    }

    public BigDecimal getMaterialCostPerSpFt() {
        return materialCostPerSpFt;
    }

    public void setMaterialCostPerSpFt(BigDecimal materialCostPerSpFt) {
        this.materialCostPerSpFt = materialCostPerSpFt;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Product getProduct() {
//        product.getCostPerSqFt();
//        product.getLaborCostPerSqFt();
//        product.getMaterialType();
        return product;
    }

    public void setProduct(Product product) {      
        this.product = product;
    }


    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public Taxes getTaxes() {
        return taxes;
    }

    public void setTaxes(Taxes taxes) {
        this.taxes = taxes;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }
    
    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }
    
    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }


}
