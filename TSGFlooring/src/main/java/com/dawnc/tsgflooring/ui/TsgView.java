/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawnc.tsgflooring.ui;

import com.dawnc.tsgflooring.dao.InvalidOrderDate;
import com.dawnc.tsgflooring.dao.TsgDaoException;
import com.dawnc.tsgflooring.dto.Order;
import com.dawnc.tsgflooring.dto.Product;
import com.dawnc.tsgflooring.dto.Taxes;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author pisce
 */
public class TsgView {
    private UserIO io;
    
    public TsgView(UserIO io){
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("--------------------<< TSG Corporation >>-----------------");
        io.print("1. Display order");
        io.print("2. Add an order");
        io.print("3. Edit an order");
        io.print("4. Remove an order");
        io.print("5. Exit");
        io.print("----------------------------------------------------------");
        return io.readInt("Please select from choices 1 - 5");
    }
    
    public void printTaxMenu(List<Taxes> taxList){
        io.print("---------------------- Tax Rate by State ---------------------");
        io.print("\tState\t\t\t\t\tTax Rate");
        io.print("--------------------------------------------------------------");
        taxList.stream()
                .map(taxRate -> String.format("%10s %1s\t\t %20s%%", 
                taxRate.getStateAbreviation() + ",",
                taxRate.getStateName(), taxRate.getTaxRate())).forEachOrdered(taxInfo -> {
                    io.print(taxInfo);
        io.print("--------------------------------------------------------------");
        });
    }    
    
     public String stateSelectionPrompt(){
        String state = io.readStringNoEmpties("Enter State abreviation:");
        return state;
    }
    
    
    public void printProductsMenu(List<Product> productList){
        io.print("..................... Materials Menu .........................");
        io.print("\tMaterial\tCost/SqFt.\tLabor/SqFt.");
        io.print("..............................................................");
        productList.stream().map(productType -> String.format("%15s %12s %15s", 
                productType.getMaterialType(), productType.getCostPerSqFt(), 
                productType.getLaborCostPerSqFt())).forEachOrdered(productInfo -> {
                    io.print(productInfo);
        });
        io.print("..............................................................");
    }
    
    public String productSelectionPrompt(List<Product> productList){
        String product = io.readStringNoEmpties("Choose desired material:");
        return product;
    }
    
    public LocalDate orderDatePrompt(){
        LocalDate orderDate = io.readDate("Enter order date you wish to find in MM-DD-YYYY format.");
         return orderDate;
    }
    
    public LocalDate futureDatePrompt(){
        LocalDate orderD = io.readFutureDate("Enter order date in MM-DD-YYYY format.");
        return orderD;
    }
    
    public void invalidOrderBanner(String message){
        io.readString("Order date does not exist. Press enter to continue.");
    }
    
    public int orderNumberPrompt(){
        int orderNumber = io.readInt("Enter order number: ");
        return orderNumber;
    }
    
    public String clientNamePrompt(){
        String clientName = io.readStringNoEmpties("Enter your name.");
        return clientName;
    }
    
    public BigDecimal areaPrompt(){
        BigDecimal area = io.readBigDecimalArea("Enter area required.");
        return area;
    }

    public void displayEditMenuBanner(){
        io.print("*********************** Edit Menu *******************************");
    }
    public void displayEditSuccessBanner(Order editedOrder){
        io.readString("Edit Complete, your order number is " + editedOrder.getOrderNumber() + "."
                + "\nPress enter to continue.");
    }
    
    public void displayCreateOrderBanner(){
        io.print("++++++++++++++++++++++++++ Add Order +++++++++++++++++++++++++++++");
    }
    
    public void purchaseCompleteMessage(Order order){
        io.readString("\nThank you for your purchase. Your order number is: " 
                + order.getOrderNumber() +"\nPress enter to continue.");
    }
    
    //addedOrderComplete is returned from service addOrder method
    public void orderQuote(Order currentOrder, List<Product>productList, List<Taxes>taxList){
            io.print("\nOrder date: " + currentOrder.getOrderDate()+
                "\nName: " + currentOrder.getClientName()+
                "\nState: " + currentOrder.getTaxes().getStateAbreviation()+ ", " 
                    + currentOrder.getTaxes().getStateName()+
                "\nTax Rate: " + currentOrder.getTaxes().getTaxRate() + "%"+
                "\nMaterial selected: " + currentOrder.getProductType()+              
                "\nArea: " + currentOrder.getArea()+
                "\nCost per SqFt: $" + currentOrder.getProduct().getCostPerSqFt() +"/SqFt" +
                "\nCost of Labor per SqFt: $" + currentOrder.getProduct().getLaborCostPerSqFt()+ "/SqFt"+
                "\nCost of material: $" + currentOrder.getMaterialCost()+
                "\nCost of labor: $" + currentOrder.getLaborCost()+
                "\nTotal taxes: $" + currentOrder.getTotalTax()+
                "\nGrand Total: $" + currentOrder.getTotal());       
    }
    
    public void editedOrderQuote(Order editFile, List<Product>productList, List<Taxes>taxList){
            io.print("\nOrder date: " + editFile.getOrderDate()+
                "\nName: " + editFile.getClientName()+
                "\nState: " + editFile.getState()+ ", " + editFile.getTaxes().getStateName()+
                "\nTax Rate: " + editFile.getTaxRate() + "%"+
                "\nMaterial selected: " + editFile.getProductType()+              
                "\nArea: " + editFile.getArea()+
                "\nCost per SqFt: $" + editFile.getCostPerSqFt() +"/SqFt" +
                "\nCost of Labor per SqFt: $" + editFile.getLaborCostPerSqFt()+ "/SqFt"+
                "\nCost of material: $" + editFile.getMaterialCost()+
                "\nCost of labor: $" + editFile.getLaborCost()+
                "\nTotal taxes: $" + editFile.getTotalTax()+
                "\nGrand Total: $" + editFile.getTotal());       
    }
    
   
    public String orderCreatedConfirmPurchasePrompt() {
        boolean yesNo = true;
        String input = "";
        io.print("\nHere is your quote.");
        while(yesNo){
            input = io.readStringNoEmpties("Do you want to place the order (Y/N)?");
            yesNo = !(input.equalsIgnoreCase("y") | input.equalsIgnoreCase("n"));   
        }  
        return input;
    }    
    
    public String editOrderNamePrompt(Order editOrderFile, List<Order> orderList){
        String editName = "";
        editName = io.readString("Do you want to edit current field: " + editOrderFile.getClientName());       
        if (editName.isBlank()){
            return editOrderFile.getClientName();
        }else{
        return editName; 
        }
    }
    
    public String editOrderStatePrompt(Order edit, List<Order> orderList){
        String editState = "";
        editState = io.readString("Do you want to edit current field: " + edit.getState().toUpperCase());       
        if (editState.isBlank()){
            return edit.getState();
        }else{    
        return editState;
        }
    }
    
    public String editOrderProductPrompt(Order edit, List<Order> orderList){
        String editProduct = "";
        editProduct = io.readString("Do you want to edit current field: " + edit.getProductType());       
        if (editProduct.isBlank()){
            return edit.getProductType();
        }else{
        return editProduct;
        }
    }
    
    public BigDecimal editOrderAreaPrompt(Order edit, List<Order> orderList){       
        String area = io.readString("Do you want to edit current field: " + edit.getArea());
        if(area.isBlank()){//if field is empty then this is true
            return edit.getArea();
        }else{
            return new BigDecimal(area);
            
        }     
    }
    
    //displays info from Order.txt file and prints them to user
    public void displayOrderList(List<Order> orderList){
        orderList.stream().forEach((currentOrder) -> io.print(
                "\nOrderNumber: " + currentOrder.getOrderNumber() +
                "\nName: " + currentOrder.getClientName()+
                "\nState: " + currentOrder.getState()+
                "\nTax rate: " + currentOrder.getTaxRate() + "%"+
                "\nMaterial selected: " + currentOrder.getProductType()+              
                "\nArea: " + currentOrder.getArea()+
                "\nCost per SqFt: $" + currentOrder.getCostPerSqFt()+ "/SqFt" +
                "\nCost of labor per SqFt: $" + currentOrder.getLaborCostPerSqFt()+ "/SqFt"+
                "\nCost of material: $" + currentOrder.getMaterialCost()+
                "\nCost of labor: $" + currentOrder.getLaborCost()+
                "\nTotal taxes: $" + currentOrder.getTotalTax()+
                "\nGrand total: $" + currentOrder.getTotal()));
        io.readString("\nPress enter to continue");
    }    
    
    public void displayOrderBanner() {
        io.print("\n********************** Orders by Date *****************************");
    }
    
    public void displayOrderByDate() {
        io.readString("Enter order date in format MM-DD-YYYY");
    }
    
    public void displayDeleteBanner(){
        io.print("^^^^^^^^^^^^^^^^^^^^^^^^^ Delete Order ^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }

    public void displayRemoveResult(Order orderEntry) {
        if(orderEntry != null) {
            io.print("Entry deleted successfully.\n");           
        }else{
            io.print("Entry does not exist.\n");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayErrorMessage(String errorMsg) {
    io.print("ERROR");
    io.print(errorMsg);
    }
    
    public void displayExitBanner(){
        io.print("Good Bye!!!");
    }
    public void displayUnknownCommandBanner(){
        io.print("Unknown Command!!!");
    }

    
}
