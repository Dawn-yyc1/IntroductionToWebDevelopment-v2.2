/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dto.Order;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author pisce
 */
public class view {
    
    private userIO io;
    
    public view(userIO io){
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("-------------------- TSG Corporation -----------------");
        io.print("1. Display order");
        io.print("2. Add an order");
        io.print("3. Edit an order");
        io.print("4. Remove an order");
        io.print("5. Exit");
        io.print("------------------------------------------------------");
        return io.readInt("Please select from choices 1 - 5");
    }
    
    public Order getOrderInfo() {
        String orderDate = io.readString("Enter date order is required(MMDDYYYY).");
        String clientName = io.readString("Enter your name.");
        String state = io.readString("Enter State.");
        BigDecimal area = io.readBigDecimal("Enter area required.");
        String productType = io.readString("Select product.");
        Order currentOrder = new Order(orderDate);
        currentOrder.setOrderDate(orderDate);
        currentOrder.setClientName(clientName);
        currentOrder.setState(state);
        currentOrder.setArea(area);
        currentOrder.setProductType(productType);
        return currentOrder;
    }    
     
    public Order editOrder() {     
        String orderDate = io.readString("Enter date order is required(MMDDYYYY).");
        String clientName = io.readString("Enter your name.");
        String state = io.readString("Enter State.");
        BigDecimal area = io.readBigDecimal("Enter area required.");
        String productType = io.readString("Select product.");
        Order editedOrder = new Order(orderDate);
        editedOrder.setOrderDate(orderDate);
        editedOrder.setClientName(clientName);
        editedOrder.setState(state);
        editedOrder.setArea(area);
        editedOrder.setProductType(productType);
        return editedOrder;
    }
    
    public void displayEditMenuBanner(){
        io.print("*********************** Edit Menu *******************************");
    }
    public void displayEditSuccessBanner(){
        io.print("Edit Complete. Press enter to continue.\n");
    }
    
    public void displayCreateOrderBanner(){
        io.print("------------------------ Add Order ---------------------------");
    }
    
    public void displayCreateSuccessBanner() {
        io.print("Order added successfully. Press enter to continue.\n");
    }
    
    public void displayList(List<Order> orderList){
        for (Order currentOrder : orderList){
            String orderInfo = String.format("%s | %s | %s | %s | %s | %s ", 
                currentOrder.getOrderDate(),
                currentOrder.getClientName(),
                currentOrder.getState(),
                currentOrder.getTaxRate(),
                currentOrder.getProductType(),               
                currentOrder.getArea());
            io.print(orderInfo);
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print("\n---------------------- All Orders  ---------------------------");
    }
    
    public void displayDeleteBanner(){
        io.print("----------------------- Delete Order ---------------------------");
    }

    public void displayRemoveResult(Order orderEntry) {
        if(orderEntry != null) {
            io.print("Entry deleted successfully.\n");           
        }else{
            io.print("Entry does not exist.\n");
        }
        io.readString("Please hit enter to continue.");
    }
    
    //field cannot be blank
    public String getClientName(){
        return io.readString("Please enter name.");
    }
    
    public String getState(){
        return io.readString("Enter State.");
    }
    
    public BigDecimal getArea(){
        return io.readBigDecimal("Enter area required.");
    }
    
//    public void displaySearchDvd(Order order){
//        if(dvd != null) {           
//            io.print(dvd.getTitle() + " | " +
//                dvd.getReleaseDate() + " | " +
//                dvd.getRating() + " | " +
//                dvd.getDirector() + " | " +
//                dvd.getStudio() + " | " +
//                dvd.getNotes());
//        }else{
//            io.print("No such Dvd.");
//        }
//        io.readString("Please hit enter to continue.");
//    }
    
    public void displayErrorMessage(String errorMsg) {
    io.print("--- ERROR ---");
    io.print(errorMsg);
    }
    
    public void displayExitBanner(){
        io.print("Good Bye!!!");
    }
    public void displayUnknownCommandBanner(){
        io.print("Unknown Command!!!");
    }
}

