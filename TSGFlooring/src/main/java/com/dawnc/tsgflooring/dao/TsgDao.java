/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawnc.tsgflooring.dao;

import com.dawnc.tsgflooring.dto.Order;
import com.dawnc.tsgflooring.dto.Product;
import com.dawnc.tsgflooring.dto.Taxes;
import java.time.LocalDate;
import java.util.List;
import java.io.FileNotFoundException;

/**
 *
 * @author pisce
 */
public interface TsgDao {
    
    //looks up order using orderDate, if entry does not
    //exist then goes to main menu
    List<Order> orderList(LocalDate orderDate)throws TsgDaoException, 
            FileNotFoundException, OrderPersistenceException, InvalidOrderDate;
    
    //creates order from info gathered in view.getOrderInfo();
    //generates orderNumber if order is placed
    //orderNumber = consecutive
    //area: min. order size = 100 sqft.
    Order addOrder(Order currentOrder)throws OrderPersistenceException, 
            FileNotFoundException, InvalidOrderDate;
    
    
    Order saveAddedOrder(Order currentOrder) throws TsgDaoException, InvalidOrderDate,
            FileNotFoundException, OrderPersistenceException;

    
    //generates menu from taxes.txt file so user can select tax rate by State abreviation 
    List<Taxes> taxList()throws TsgDaoException, FileNotFoundException;
    
    //generates menu from product.txt file so user can select material
    List<Product> productList()throws TsgDaoException, FileNotFoundException;  
    
    //looks up order via orderDate and orderNumber
    Order editOrder(Order editFile)throws TsgDaoException, FileNotFoundException;
    
    Order validateFileDateOrderNum(LocalDate orderDateQuery, int orderNumQuery) 
            throws TsgDaoException, FileNotFoundException;
    
    Order saveEditedOrder(Order editedOrder)throws TsgDaoException, 
            FileNotFoundException, OrderPersistenceException, InvalidOrderDate;

    //removes order if orderDate and orderNumber matches
    Order removeOrder(LocalDate orderDate, int orderNumber)throws TsgDaoException, 
            FileNotFoundException, InvalidOrderDate;
}
