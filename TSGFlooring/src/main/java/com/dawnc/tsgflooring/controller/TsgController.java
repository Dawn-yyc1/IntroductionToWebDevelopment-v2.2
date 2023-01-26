/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawnc.tsgflooring.controller;

import com.dawnc.tsgflooring.dao.InvalidOrderDate;
import com.dawnc.tsgflooring.dao.InvalidInputException;
import com.dawnc.tsgflooring.dao.OrderPersistenceException;
import com.dawnc.tsgflooring.dao.TsgDaoException;
import com.dawnc.tsgflooring.dto.Order;
import com.dawnc.tsgflooring.dto.Product;
import com.dawnc.tsgflooring.dto.Taxes;
import com.dawnc.tsgflooring.service.TsgService;
import com.dawnc.tsgflooring.ui.TsgView;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author pisce
 */
public class TsgController {
    private TsgView view;
    private TsgService service;
    
    public TsgController(TsgView view, TsgService service){
        this.service = service;
        this.view = view;
    }
    
    public void run() throws TsgDaoException, InvalidInputException, FileNotFoundException, 
            OrderPersistenceException, InvalidOrderDate {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        findOrderByDate();//displayOrder
                        break;
                    case 2:
                        addOrder();//addOrder();
                         break;
                    case 3:
                        editOrder();
                        break;
                    case 4:
                        removeOrder();
                        break;
                    case 5:                       
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
            }catch(TsgDaoException | InvalidInputException  e){
            view.displayErrorMessage(e.getMessage());
            }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private Order addOrder()throws TsgDaoException, InvalidInputException, FileNotFoundException, OrderPersistenceException, InvalidOrderDate {
        view.displayCreateOrderBanner();
        LocalDate orderDate = view.futureDatePrompt();
        String clientName = view.clientNamePrompt();
        BigDecimal area = view.areaPrompt();
        List<Product> productList = service.productList();
        view.printProductsMenu(productList);
        String product = view.productSelectionPrompt(productList);
        Product productSelected = new Product(product); //puts material selected by user into an object called productSelected                  
        List<Taxes> taxList = service.taxList();
        view.printTaxMenu(taxList);
        String state = view.stateSelectionPrompt();
        Taxes stateSelected = new Taxes(state);//puts state selected by user into an object called stateSelected       
        Order currentOrder = new Order(orderDate, clientName, productSelected, stateSelected, area); 
        service.confirmCurrentOrder(currentOrder);
        view.orderQuote(currentOrder, service.productList(), service.taxList());
        String confirmOrder = view.orderCreatedConfirmPurchasePrompt();                
            if(confirmOrder.equalsIgnoreCase("n")){
            view.printMenuAndGetSelection(); //goes to main menu
            }else if(confirmOrder.equalsIgnoreCase("y")){ 
                service.saveAddedOrder(currentOrder);
//                service.confirmCurrentOrder(currentOrder);
                view.purchaseCompleteMessage(currentOrder);
                view.printMenuAndGetSelection();
            }
        return currentOrder;    
    }
    
    //was LocalDate
    private void findOrderByDate()throws InvalidOrderDate, TsgDaoException, FileNotFoundException, OrderPersistenceException{
        view.displayOrderBanner();
        LocalDate orderDate = view.orderDatePrompt();
        List<Order> orderList = service.orderList(orderDate);
        view.displayOrderList(orderList);
        view.printMenuAndGetSelection();
        
    }
    
    private Order editOrder()throws TsgDaoException, FileNotFoundException, OrderPersistenceException, InvalidOrderDate{   
        view.displayEditMenuBanner();
        LocalDate orderDateQuery = view.orderDatePrompt();
        int orderNumQuery = view.orderNumberPrompt();       
        List<Order> orderList = service.orderList(orderDateQuery);
        Order fileToEdit = service.validateFileDateOrderNum(orderDateQuery, orderNumQuery);
        String editName = view.editOrderNamePrompt(fileToEdit, orderList);
        view.printTaxMenu(service.taxList());
        String editState = view.editOrderStatePrompt(fileToEdit,orderList);
        view.printProductsMenu(service.productList());
        String editProductType = view.editOrderProductPrompt(fileToEdit,orderList);
        BigDecimal editArea = view.editOrderAreaPrompt(fileToEdit, orderList);
        Order editedOrder = new Order(orderDateQuery, orderNumQuery, editName, editState, editProductType, editArea);
        editedOrder = service.editOrder(editedOrder);
        view.orderQuote(editedOrder, service.productList(), service.taxList());
        String confirmOrder = view.orderCreatedConfirmPurchasePrompt();                
            if(confirmOrder.equalsIgnoreCase("n")){
            view.printMenuAndGetSelection(); //goes to main menu
            }else if(confirmOrder.equalsIgnoreCase("y")){ 
                // dao.getCostLaborInfo has setters
                // service.editOrder has setter to save user info after everything is calculated            
                service.saveEditedOrder(editedOrder);
        view.displayEditSuccessBanner(editedOrder);
        }
        return editedOrder;
    }
    
    private void removeOrder()throws TsgDaoException{
        view.displayDeleteBanner();   
    }
    
    private void unknownCommand() {
    view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }     
}    

