/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template editFile, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawnc.tsgflooring.dao;

import com.dawnc.tsgflooring.dto.Order;
import com.dawnc.tsgflooring.dto.Product;
import com.dawnc.tsgflooring.dto.Taxes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pisce
 */
public class TsgDaoFileImpl implements TsgDao{
    public static final String PRODUCT_FILE = "Products.txt";
    public static final String TAX_FILE = "Taxes.txt";
    //the "/" denotes where the files will be stored
    public static String ORDER_FILE = "Orders/";
    public static final String DELIMITER = ",";
    private Map<Integer, Order> orderMap = new HashMap<>(); //int orderNumber = key
    private Map<String, Taxes> taxMap = new HashMap<>(); //String State = key
    private Map<String, Product> productMap = new HashMap<>(); //String product = key
    private List<Product> newProductList;
    private List<Taxes> newTaxList;
    
    @Override
    public Order addOrder(Order currentOrder) throws OrderPersistenceException, 
            FileNotFoundException, InvalidOrderDate{
        try {
            loadOrderFile(currentOrder.getOrderDate());//load editFile, make sure editFile exisits          
            getCostLaborInfo(currentOrder);//asks user if they want to purchase order
        } catch (OrderPersistenceException | TsgDaoException ex) {
            Logger.getLogger(TsgDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return currentOrder;
    }
    
    @Override 
    public Order saveAddedOrder(Order currentOrder) throws TsgDaoException, 
            FileNotFoundException, OrderPersistenceException, InvalidOrderDate{
        LocalDate writeOrder1 = currentOrder.getOrderDate();
        String formatedDate = currentOrder.getOrderDate().format(DateTimeFormatter.ofPattern("MMddyyyy"));
        File getFile =  new File(ORDER_FILE + "/Orders_" + formatedDate + ".txt");
        //file exist: generate orderNum, set orderNum, put object in orderMap and write to txt file
        if(getFile.exists()){
            int orderNum = orderMap.size();
            currentOrder.setOrderNumber(++orderNum);
            orderMap.put(orderNum, currentOrder);   
            writeFile(writeOrder1);    
        }else if(!getFile.exists()){
            //file doesn't exist: generate orderNum, set orderNum, put object in 
            //orderMap and write to txt file
            getFile =  new File(ORDER_FILE + "/Orders_" + formatedDate + ".txt");
            int orderNum = orderMap.size();
            currentOrder.setOrderNumber(++orderNum);
            orderMap.put(orderNum, currentOrder);   
            writeFile(writeOrder1);
        }
        return currentOrder;
    }
        
    //orderNum and orderDate is existing 
    @Override 
    public Order saveEditedOrder(Order editedOrder)throws TsgDaoException, 
            FileNotFoundException, OrderPersistenceException, InvalidOrderDate{     
            orderMap.put(editedOrder.getOrderNumber(), editedOrder);   
            LocalDate writeOrder1 = editedOrder.getOrderDate();
//            try {
                writeFile(writeOrder1);
//                //if false: generate orderNum and add value to orderMap
//            } catch (OrderPersistenceException ex) {
//                throw new OrderPersistenceException("Order cannot be written", ex);
//            }
            return editedOrder;
//        }else{
//            String formatedDate = currentOrder.getOrderDate().format(DateTimeFormatter.ofPattern("MMddyyyy"));
//            File getFile =  new File(ORDER_FILE + "/Orders_" + formatedDate + ".txt");
//            int orderNum = orderMap.size();
//            currentOrder.setOrderNumber(orderNum++);
//            orderMap.put(orderNum, currentOrder);
//            LocalDate writeOrder2 = currentOrder.getOrderDate();
//            try {
//                writeFile(writeOrder2);
//            } catch (OrderPersistenceException ex) {
//                throw new OrderPersistenceException("Order can not be written", ex);
//            }
//        
    }
    
    @Override
    public List<Taxes> taxList() throws TsgDaoException, FileNotFoundException {
        loadTaxFile();
        return new ArrayList<Taxes>(taxMap.values());
    }

    @Override
    public List<Product> productList() throws TsgDaoException, FileNotFoundException{
        loadProductFile();
        return new ArrayList<Product>(productMap.values());
    }
    
    //method for findOrderByDate
    @Override
    public List<Order> orderList(LocalDate orderDate) throws TsgDaoException, 
            FileNotFoundException, OrderPersistenceException, InvalidOrderDate{   
        try {        
            loadOrderFile(orderDate);
        } catch (FileNotFoundException | OrderPersistenceException ex) {
            throw new InvalidOrderDate("Order does not exist", ex);
        }
        return new ArrayList<Order>(orderMap.values());
    }

    @Override
    public Order editOrder(Order editFile) throws TsgDaoException, FileNotFoundException{
        Order editedFile = getCostLaborInfo(editFile);        
        return editedFile;
    }

    @Override
    public Order removeOrder(LocalDate orderDate, int orderNumber) throws 
            TsgDaoException, FileNotFoundException, InvalidOrderDate {
        try {
            loadOrderFile(orderDate);
        } catch (OrderPersistenceException ex) {
            throw new FileNotFoundException("File not found");
        }
        Order removedOrder = orderMap.remove(orderDate);
//        int orderNumber = 
//        writeFile();
        return removedOrder;
    }
    
    @Override
    public Order validateFileDateOrderNum(LocalDate orderDateQuery, int orderNumQuery) 
            throws TsgDaoException, FileNotFoundException{
        String formatedDate = orderDateQuery.format(DateTimeFormatter.ofPattern("MMddyyyy"));
//        String getExistingFile = ORDER_FILE + "/Orders_" + formatedDate + ".txt";
        File getFile =  new File(ORDER_FILE + "/Orders_" + formatedDate + ".txt");
//        String file;
        if(getFile.exists()); //true, find file
        try {
            //                file = getFile.getName();
            loadOrderFile(orderDateQuery);
//                System.out.println(file);
        } catch (OrderPersistenceException | InvalidOrderDate ex) {
            throw new TsgDaoException("Order does not exist, VALIDATE DAO", ex);
        }
           
            return orderMap.get(orderNumQuery); 
            //if file does not exist and orderMap is empty, create file
//            if(!getFile.exists() && orderMap.isEmpty()){
//                getFile = new File (ORDER_FILE + "/Orders_" + formatedDate + ".txt");
//                Order newFile = orderMap.put(generateOrderNumber(), value);
//                
//                Order nf = new Order());
//                return newfile;

//        }catch(TsgDaoException ex){
//            System.out.println(ex.getStackTrace());    
//            throw new FileNotFoundException("Order does not exist, VALIDATE DAO");
//        }
//        return file;    
    }
    
//     generates orderNumber for Order currentOrder
//    private int generateOrderNumber() throws TsgDaoException, FileNotFoundException{      
//        int nextOrderNum = orderMap.size();       
//        return nextOrderNum++; 
//    }
    
     //gathers info from user to draft a quote, gets Tax and Product items from arrayList using
    //lambdas. Setters used to save info into one object
    public Order getCostLaborInfo (Order currentOrder) throws TsgDaoException, FileNotFoundException{
        newProductList = productList();
        newTaxList = taxList();        
        Product newProduct = newProductList.stream()
                    .filter(p-> p.getMaterialType().equalsIgnoreCase(currentOrder.getProductType()))
                    .findFirst()
            .get();
        Product productSelection = new Product(currentOrder.getProductType(), 
                newProduct.getCostPerSqFt(), newProduct.getLaborCostPerSqFt());       
//gets the taxRate that is associated with the State
        Taxes taxRateByState = newTaxList.stream()
                .filter(t -> t.getStateAbreviation().equalsIgnoreCase(currentOrder.getState()))
                .findFirst()
                .get();                      
        currentOrder.setOrderDate(currentOrder.getOrderDate());
        currentOrder.setClientName(currentOrder.getClientName());
        currentOrder.setState(currentOrder.getState());
        currentOrder.setProduct(productSelection);
        currentOrder.setCostPerSqFt(productSelection.getCostPerSqFt());
        currentOrder.setLaborCostPerSqFt(productSelection.getLaborCostPerSqFt());
        currentOrder.setArea(currentOrder.getArea());   
        currentOrder.setTaxes(taxRateByState);//sets the object, Taxes
        currentOrder.setTaxRate(taxRateByState.getTaxRate());//returns BigDecimal taxRate for the state 
               
        return currentOrder;
    }
      
    private Product unmarshallProduct(String productAsText) throws TsgDaoException{
          String[] productToken = productAsText.split(DELIMITER);
          String materialType = productToken[0];
          Product productFromFile = new Product(materialType);
          productFromFile.setCostPerSqFt(new BigDecimal(productToken[1]));
          productFromFile.setLaborCostPerSqFt(new BigDecimal(productToken[2]));
          return productFromFile;
      }  
    
    private Taxes unmarshallTaxes(String taxesAsText) throws TsgDaoException{
          String[] taxToken = taxesAsText.split(DELIMITER);
          String stateAbreviation = taxToken[0];
          Taxes taxFromFile = new Taxes(stateAbreviation);
          taxFromFile.setStateName(taxToken[1]);
          taxFromFile.setTaxRate(new BigDecimal(taxToken[2]));
          return taxFromFile;
      }  
    
    private Order unmarshallOrder(String currentOrder) throws TsgDaoException {
        String[] orderToken = currentOrder.split(DELIMITER);
        int orderNumber = Integer.parseInt(orderToken[0]);
        Order orderFromFile = new Order(orderNumber);
        orderFromFile.setOrderNumber(Integer.parseInt(orderToken[0]));
        orderFromFile.setClientName(orderToken[1]);
        orderFromFile.setState((orderToken[2]));
        orderFromFile.setTaxRate((new BigDecimal(orderToken[3])));
        orderFromFile.setProductType((orderToken[4]));
        orderFromFile.setArea(new BigDecimal(orderToken[5]));
        orderFromFile.setCostPerSqFt(new BigDecimal(orderToken[6]));
        orderFromFile.setLaborCostPerSqFt(new BigDecimal(orderToken[7]));
        orderFromFile.setMaterialCost(new BigDecimal(orderToken[8]));
        orderFromFile.setLaborCost(new BigDecimal(orderToken[9]));
        orderFromFile.setTotalTax(new BigDecimal(orderToken[10]));
        orderFromFile.setTotal(new BigDecimal(orderToken[11]));
        return orderFromFile;
    }
    
    private void loadProductFile()throws TsgDaoException, FileNotFoundException {
        Scanner reader;
        try {
            reader = new Scanner (new BufferedReader(new FileReader(PRODUCT_FILE)));
        }catch (FileNotFoundException ex) {
            throw new TsgDaoException("Could not load PRODUCT FILE", ex);
        }
        String currentLine; 
        Product currentProduct;
        while (reader.hasNextLine()){
            currentLine = reader.nextLine();
            currentProduct = unmarshallProduct(currentLine);
            productMap.put(currentProduct.getMaterialType(), currentProduct);
        }    
        reader.close();
    }
    
    private void loadTaxFile()throws TsgDaoException, FileNotFoundException {
        Scanner reader;
        try {
            reader = new Scanner (new BufferedReader(new FileReader(TAX_FILE)));
        }catch (FileNotFoundException ex) {
            throw new TsgDaoException("Could not load TAX FILE", ex);
        }
        String currentLine; 
        Taxes currentTax;
        while (reader.hasNextLine()){
            currentLine = reader.nextLine();
            currentTax = unmarshallTaxes(currentLine);
            taxMap.put(currentTax.getStateAbreviation(), currentTax);
        }    
        reader.close();
    }
    
    //if order is new, it will create a new editFile with the orderDate
    //if order is existing, it will read the editFile
    private void loadOrderFile(LocalDate orderDate)throws OrderPersistenceException, 
            TsgDaoException, FileNotFoundException, InvalidOrderDate {
        Scanner reader; 
        String formatedDate = orderDate.format(DateTimeFormatter.ofPattern("MMddyyyy"));
        String getExistingFile = ORDER_FILE + "/Orders_" + formatedDate + ".txt";
//        File orderFile = new File (ORDER_FILE + "/Orders_" + formatedDate + ".txt"); 
//        if(!orderFile.exists() && orderMap.isEmpty()){
//                String newFileName = orderDate.format(DateTimeFormatter.ofPattern("MMddyyyy")); 
//                orderFile = new File (ORDER_FILE + "/Orders_" + newFileName + ".txt");
//                return;
//            }    
////        try{
//            do{
                try {     
                    reader = new Scanner (new BufferedReader(new FileReader(getExistingFile)));
                }catch(FileNotFoundException ex){
                    System.out.println(ex.getStackTrace());
                    System.out.println(ex.getMessage());
                    throw new InvalidOrderDate("Order does not exist", ex);
                }               
                String currentLine; 
                Order currentOrder;
                while (reader.hasNextLine()){
                    try{
                    currentLine = reader.nextLine();
                    currentOrder = unmarshallOrder(currentLine);
                    orderMap.put(currentOrder.getOrderNumber(), currentOrder);
                    }catch(NullPointerException e){
                        System.out.println("skip null value");
                    }
                }    
                reader.close();              
//            }while(orderMap.equals(orderMap.size()));
            
//        }catch(Exception e){
//            System.out.println(e.getStackTrace());
//            System.out.println(e.getMessage());
//            throw new TsgDaoException ("Order does not exist.", e);
//        }
    } 
    
    //saves order
    private String marshallOrder (Order orderAdded) throws TsgDaoException {          
        String orderAsText = orderAdded.getOrderNumber()+ DELIMITER;
        orderAsText += orderAdded.getClientName()+ DELIMITER;
//        orderAsText += orderAdded.getTaxes().getStateAbreviation()+ DELIMITER;
        orderAsText += orderAdded.getState() + DELIMITER;
//        orderAsText += orderAdded.getTaxes().getTaxRate() + DELIMITER;
        orderAsText += orderAdded.getTaxRate() + DELIMITER;
        orderAsText += orderAdded.getProductType() + DELIMITER;
        orderAsText += orderAdded.getArea()+ DELIMITER;
//        orderAsText += orderAdded.getProduct().getCostPerSqFt() + DELIMITER;
        orderAsText += orderAdded.getCostPerSqFt() + DELIMITER;
        orderAsText += orderAdded.getLaborCostPerSqFt() + DELIMITER;
//        orderAsText += orderAdded.getProduct().getLaborCostPerSqFt() + DELIMITER;

    //next 4 items is calculated in Service using calculateQuote method()
        orderAsText += orderAdded.getMaterialCost() + DELIMITER;
        orderAsText += orderAdded.getLaborCost() + DELIMITER;
        orderAsText += orderAdded.getTotalTax() + DELIMITER;
        orderAsText += orderAdded.getTotal();
        return orderAsText;
    }
   
    private void writeFile(LocalDate orderDate) throws TsgDaoException, 
            FileNotFoundException, OrderPersistenceException, InvalidOrderDate {
        PrintWriter out;

        String formatedDate = orderDate.format(DateTimeFormatter.ofPattern("MMddyyyy"));
        String getExistingFile = ORDER_FILE + "/Orders_" + formatedDate + ".txt";
        try { 
            out = new PrintWriter(new FileWriter(getExistingFile));
//            out = new PrintWriter(new FileWriter(getFile(orderDate), true));          
        }catch(IOException e){
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            throw new TsgDaoException("Could not write to file.", e);            
        }
        String orderAsText;
        List<Order> pd = this.orderList(orderDate);
        for(Order currentOrder : pd) {
            orderAsText = marshallOrder(currentOrder);
            out.println(orderAsText);
//            out.write(orderAsText);
            out.flush();
        }
        out.close();
    }

}
