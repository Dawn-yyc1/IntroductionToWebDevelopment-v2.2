/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawnc.tsgflooring.ui;
 
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author pisce
 */
public class UserIOConsoleImpl implements UserIO{
    final private Scanner console = new Scanner(System.in);

    /**
     *
     * A very simple method that takes in a message to display on the console 
     * and then waits for a integer answer from the user to return.
     *
     * @param msg - String of information to display to the user.
     *
     */
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public void printf(String msg) {
        System.out.printf(msg);
    }
            
            
    /**
     *
     * A simple method that takes in a message to display on the console, 
     * and then waits for an answer from the user to return.
     *
     * @param msgPrompt - String explaining what information you want from the user.
     * @return the answer to the message as string
     */
    @Override
    public String readStringNoEmpties(String msgPrompt) {
        String input= "";
        boolean notEmpty = true;
        System.out.println(msgPrompt);
        while(input.isBlank()){//if true, the code block executes
            input = console.nextLine();  
//            this.print("Field cannot be empty.");  
            notEmpty = false;
        }
        return input;
    }
    
    @Override
    public String readString(String prompt){
        System.out.println(prompt);
        return console.nextLine();
    }
    
    /**
     *
     * A simple method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter an integer
     * to be returned as the answer to that message.
     *
     * @param msgPrompt - String explaining what information you want from the user.
     * @return the answer to the message as integer
     */
    @Override
    public int readInt(String msgPrompt) {
        boolean invalidInput = true;
        int num = 0;
        while (invalidInput) {
            try {
                String stringValue = this.readStringNoEmpties(msgPrompt);
                num = Integer.parseInt(stringValue); 
                //breaks loop and stops prompting user, otherwise line 85 will repeat
                invalidInput = false;
                } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
        return num;
    }

    /**
     *
     * A slightly more complex method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter an integer
     * within the specified min/max range to be returned as the answer to that message.
     *
     * @param msgPrompt - String explaining what information you want from the user.
     * @param min - minimum acceptable value for return
     * @param max - maximum acceptable value for return
     * @return an integer value as an answer to the message prompt within the min/max range
     */
    @Override
    public int readInt(String msgPrompt, int min, int max) {
        int result;
        do {
            result = readInt(msgPrompt);
        } while (result < min || result > max);

        return result;
    }

    /**
     *
     * A simple method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter a long
     * to be returned as the answer to that message.
     *
     * @param msgPrompt - String explaining what information you want from the user.
     * @return the answer to the message as long
     */
    @Override
    public long readLong(String msgPrompt) {
        while (true) {
            try {
                return Long.parseLong(this.readStringNoEmpties(msgPrompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }

    /**
     * A slightly more complex method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter a double
     * within the specified min/max range to be returned as the answer to that message.
     *
     * @param msgPrompt - String explaining what information you want from the user.
     * @param min - minimum acceptable value for return
     * @param max - maximum acceptable value for return
     * @return an long value as an answer to the message prompt within the min/max range
     */
    @Override
    public long readLong(String msgPrompt, long min, long max) {
        long result;
        do {
            result = readLong(msgPrompt);
        } while (result < min || result > max);

        return result;
    }

    /**
     *
     * A simple method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter a float
     * to be returned as the answer to that message.
     *
     * @param msgPrompt - String explaining what information you want from the user.
     * @return the answer to the message as float
     */
    @Override
    public float readFloat(String msgPrompt) {
        while (true) {
            try {
                return Float.parseFloat(this.readString(msgPrompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }

    /**
     *
     * A slightly more complex method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter a float
     * within the specified min/max range to be returned as the answer to that message.
     *
     * @param msgPrompt - String explaining what information you want from the user.
     * @param min - minimum acceptable value for return
     * @param max - maximum acceptable value for return
     * @return an float value as an answer to the message prompt within the min/max range
     */
    @Override
    public float readFloat(String msgPrompt, float min, float max) {
        float result;
        do {
            result = readFloat(msgPrompt);
        } while (result < min || result > max);

        return result;
    }

    /**
     *
     * A simple method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter a double
     * to be returned as the answer to that message.
     *
     * @param msgPrompt - String explaining what information you want from the user.
     * @return the answer to the message as double
     */
    @Override
    public double readDouble(String msgPrompt) {
        while (true) {
            try {
                return Double.parseDouble(this.readString(msgPrompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }

    /**
     *
     * A slightly more complex method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter a double
     * within the specified min/max range to be returned as the answer to that message.
     *
     * @param msgPrompt - String explaining what information you want from the user.
     * @param min - minimum acceptable value for return
     * @param max - maximum acceptable value for return
     * @return an double value as an answer to the message prompt within the min/max range
     */
    @Override
    public double readDouble(String msgPrompt, double min, double max) {
        double result;
        do {
            result = readDouble(msgPrompt);
        } while (result < min || result > max);
        return result;
    }

    @Override
    public BigDecimal printBigDecimal(String prompt, BigDecimal message) {
        this.print(prompt);
        return console.nextBigDecimal();   
    }
//crashes when user pushes enter
    @Override
    public BigDecimal readBigDecimalArea(String prompt) {
        BigDecimal minOrder = new BigDecimal("100");
        boolean validInput = true;
        BigDecimal bd = null; 
        this.print(prompt);
//        BigDecimal bd = new BigDecimal(console.nextLine());
//        this.print(prompt);
            while(validInput) {//true               
                try{
                    bd = new BigDecimal(console.nextLine());
                    if(bd.compareTo(minOrder) == 0 || bd.compareTo(minOrder) == 1){//true
                        return bd.setScale(2, RoundingMode.HALF_UP);  
                    }else if(bd.compareTo(minOrder) == -1){ //false 
                        this.print("Invalid input. Minimum order is 100 sqft., please try again");  
//                    }else if("".equals(console.nextLine())){
//                        this.print("Field cannot be empty.");
                    }
                }catch(Exception e){
                    this.print("Enter a valid number");
                }
            }
            return bd;
    }
   
    @Override
    public LocalDate readDate(String prompt){
        LocalDate date = null;
        boolean bool = true;
        this.print(prompt);
        while(bool || (console.nextLine().length() < 8)){
            try{
                date = LocalDate.parse(console.nextLine(), DateTimeFormatter.ofPattern
                ("MM[-][/][ ]dd[-][/][ ]yyyy"));
                return date;
            }catch(Exception e) { 
                    System.out.println("Invalid date error!!");
            }
        }
        return date;
    }
    
    @Override
    public LocalDate readFutureDate(String prompt){
        LocalDate today = LocalDate.now();
        boolean isFutureDate = true;
        LocalDate date = null;
        
        while(isFutureDate){
            try{ 
                this.print(prompt);
                date = LocalDate.parse(console.nextLine(),DateTimeFormatter.ofPattern("MM[-][/][ ]dd[-][/][ ]yyyy"));
//                DateTimeFormatter is case sensitive 
                if(date.isAfter(today)){
                    isFutureDate = false;
                    return date;
                }else{
                    this.print("Date must be in the future, please try again.");                    
                }
            }catch(Exception e) { 
                System.out.println("Invalid date error!!");
            }            
        }
        return date;   
    }
}

    