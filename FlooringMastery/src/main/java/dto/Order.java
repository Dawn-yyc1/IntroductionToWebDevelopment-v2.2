/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.math.BigDecimal;

/**
 *
 * @author pisce
 */
public class Order {
    private String orderDate;
    private String clientName;
    private String state;
    private BigDecimal taxRate;
    private String productType;
    private BigDecimal area;

public Order(String orderDate){
     this.orderDate = orderDate;
}

public Order(String orderDate, String clientName, String state, BigDecimal taxRate,
String productType, BigDecimal area){
    this.orderDate = orderDate;
    this.clientName = clientName;
    this.state = state;
    this.taxRate = taxRate;
    this.productType = productType;
    this.area = area;
}

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getClientName() {
        return clientName;
    }

    //use data validation rules here?
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    //get taxRate from file?
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

}