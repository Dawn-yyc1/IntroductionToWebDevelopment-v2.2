/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawnc.tsgflooring.service;

import com.dawnc.tsgflooring.dao.InvalidOrderDate;
import com.dawnc.tsgflooring.dao.OrderPersistenceException;
import com.dawnc.tsgflooring.dao.TsgDaoException;
import com.dawnc.tsgflooring.dto.Order;
import com.dawnc.tsgflooring.dto.Product;
import com.dawnc.tsgflooring.dto.Taxes;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author pisce
 */
public interface TsgService {
    
//looks up order using orderDate, if entry does not exist then goes to main menu
    List<Order> orderList(LocalDate orderDate)throws TsgDaoException, 
            FileNotFoundException, OrderPersistenceException, InvalidOrderDate;
    
//controller uses prompts in View to gather info from customer and then saves it into an 
//object. Object passes through method in Dao called getCostLaborInfo to get cost/sqft and
//material/sqft. Object is then passed to service.confirmCurrentOrder to calculate 
//laborCost, materialCost, totalTax, totalTotal to generate quote    
    Order addOrder(Order currentOrder)throws TsgDaoException, FileNotFoundException,
            InvalidOrderDate;   
    
//used in addOrder to calculated remaining fields. Uses a method called calculatedQuote to 
//perform calculations
    Order confirmCurrentOrder (Order currentOrder) throws TsgDaoException, 
            FileNotFoundException, InvalidOrderDate;  
    
    Order saveAddedOrder(Order currentOrder)throws TsgDaoException, FileNotFoundException,
            OrderPersistenceException, InvalidOrderDate;

//generates menu from taxes.txt file so user can select tax rate by State abreviation 
    List<Taxes> taxList()throws TsgDaoException, FileNotFoundException;
    
//generates menu from product.txt file so user can select material
    List<Product> productList()throws TsgDaoException, FileNotFoundException;
    
        
//looks up order via orderDate
    Order editOrder(Order editFile)throws TsgDaoException, FileNotFoundException;
    
    Order saveEditedOrder(Order editedOrder)throws TsgDaoException, 
            FileNotFoundException, OrderPersistenceException, InvalidOrderDate;
    
    Order validateFileDateOrderNum(LocalDate orderDateQuery, int orderNumQuery) 
            throws TsgDaoException, FileNotFoundException;
    
//removes order if orderDate and orderNumber matches
    Order removeOrder(LocalDate orderDate, int orderNumber)throws TsgDaoException, 
            FileNotFoundException, InvalidOrderDate;
}
