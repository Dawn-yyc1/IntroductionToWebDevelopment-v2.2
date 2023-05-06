/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Order;

/**
 *
 * @author pisce
 */
public interface dao {
    
    //creates order from info gathered in view.getOrderInfo();
    //generates orderNumber if order is placed
    //orderNumber = consecutive
    //area: min. order size = 100 sqft.
    Order addOrder(String orderDate, Order order);
    
    //looks up order using orderDate, if entry does not
    //exist then goes to main menu
    Order displayOrder(String orderDate, Order order);
    
    //looks up order via orderDate and orderNumber
    Order editOrder(String orderDate, Order order);
    
    //removes order if orderDate and orderNumber matches
    Order removeOrder(String orderDate, Order order);
    
}
