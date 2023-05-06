/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawnc.tsgflooring.service;

import com.dawnc.tsgflooring.dao.InvalidOrderDate;
import com.dawnc.tsgflooring.dao.OrderPersistenceException;
import com.dawnc.tsgflooring.dao.TsgDao;
import com.dawnc.tsgflooring.dao.TsgDaoException;
import com.dawnc.tsgflooring.dto.Order;
import com.dawnc.tsgflooring.dto.Product;
import com.dawnc.tsgflooring.dto.Taxes;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author pisce
 */
public class TsgServiceImpl implements TsgService{
    
    private TsgDao dao;
    
    public TsgServiceImpl (TsgDao myDao){
        this.dao = myDao;
    }
    
    //gets info from customer
    @Override
    public Order addOrder(Order currentOrder) throws TsgDaoException, 
            FileNotFoundException, InvalidOrderDate { 
        try {
             currentOrder = dao.addOrder(currentOrder);
             
        } catch (OrderPersistenceException ex) {
            Logger.getLogger(TsgServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return currentOrder;
    }
    
    //takes in currentOrder and uses it to calculate quotes. Asks customer to confirm order.
    //If "yes", orderNum is generated and info is saved and written to file
    @Override
    public Order confirmCurrentOrder (Order currentOrder) throws TsgDaoException, 
            FileNotFoundException, InvalidOrderDate{       
        try {
            currentOrder = dao.addOrder(currentOrder);    
        } catch (OrderPersistenceException ex) {
            Logger.getLogger(TsgServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return calculateQuote(currentOrder);
    }
    
    @Override
    public Order saveEditedOrder(Order editedOrder)throws TsgDaoException, 
            FileNotFoundException, OrderPersistenceException, InvalidOrderDate{
        return dao.saveEditedOrder(editedOrder);
    }
    
    @Override
    public Order saveAddedOrder(Order currentOrder)throws TsgDaoException, InvalidOrderDate,
            FileNotFoundException, OrderPersistenceException{        
        return dao.saveAddedOrder(currentOrder);
    }
      
    @Override
    public List<Taxes> taxList() throws TsgDaoException, FileNotFoundException {
        return dao.taxList();
    }   

    @Override
    public List<Product> productList() throws TsgDaoException, FileNotFoundException  {
       return dao.productList();
    }

    @Override
    public List<Order> orderList(LocalDate orderDate) throws TsgDaoException, 
            FileNotFoundException, OrderPersistenceException,InvalidOrderDate {            
        List ordersByDate = dao.orderList(orderDate);
        if(ordersByDate == null){
            throw new FileNotFoundException("There are no orders on that date.");
        }
        return ordersByDate;
    }

    @Override
    public Order editOrder(Order editFile) throws TsgDaoException, FileNotFoundException {
//        List<Order> orderList = null;
//        try {
//             orderList = dao.orderList(editFile.getOrderDate());
//        } catch (OrderPersistenceException | InvalidOrderDate ex) {
//            Logger.getLogger(TsgServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        orderList.stream()
//                .filter(p -> p.getOrderDate().equals(editFile.getOrderDate()));
        
        
        Order calculatedEditOrderQuote = dao.editOrder(editFile);            
        calculateQuote(editFile);  
        return calculatedEditOrderQuote;
    }

    @Override
    public Order validateFileDateOrderNum(LocalDate orderDateQuery, int orderNumQuery)throws TsgDaoException, FileNotFoundException{
        return dao.validateFileDateOrderNum(orderDateQuery, orderNumQuery);
    }
    
    
    @Override
    public Order removeOrder(LocalDate orderDate, int orderNumber) throws 
            TsgDaoException, FileNotFoundException, InvalidOrderDate {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//takes currentOrder object from addOrder and calculates materialCost, laborCost, 
//totalTaxes, grandTotal. Setters then store the info back into currentOrder
    public Order calculateQuote(Order currentOrder) throws TsgDaoException, FileNotFoundException {
              
        BigDecimal taxDecimal = (currentOrder.getTaxes().getTaxRate())
            .divide(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP);
        
        BigDecimal materialCost = (currentOrder.getProduct().getCostPerSqFt())
                .multiply(currentOrder.getArea()).setScale(2, RoundingMode.HALF_UP);
        
        BigDecimal laborCost = (currentOrder.getProduct().getLaborCostPerSqFt())
                .multiply(currentOrder.getArea()).setScale(2, RoundingMode.HALF_UP);
        
        BigDecimal totalTaxes = ((materialCost.add(laborCost)).multiply(taxDecimal)).setScale(2, RoundingMode.HALF_UP);
        
        BigDecimal grandTotal = materialCost.add(laborCost).add(totalTaxes);  

        currentOrder.setMaterialCost(materialCost);
        currentOrder.setLaborCost(laborCost);
        currentOrder.setTotalTax(totalTaxes);
        currentOrder.setTotal(grandTotal);
        return currentOrder;       
    }

}
