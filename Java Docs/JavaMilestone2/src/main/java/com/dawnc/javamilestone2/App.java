/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawnc.javamilestone2;

import java.util.Scanner;

/**
 *
 * @author pisce
 */
public class App {
    public static void main(String[] args) {
        
   

    //user input for operator and operands
    double num1; 
    double num2; 
    double sum = 0;
    String operator;
    String stringNum1 = "";
    String stringNum2 = "";
     
    
    Scanner ask = new Scanner(System.in);
    
   // while(true){
         
        //prompt user to choose operation
            System.out.println("Choose your operation: ");
            System.out.println("press a to add");
            System.out.println("press s to subtract");
            System.out.println("press d to divide");
            System.out.println("press m to multiply");
            
            operator = ask.nextLine();
            System.out.println();
            
        //prompt user to choose operands
            System.out.println("Choose a number");      
            num1 = Double.parseDouble(stringNum1);
            System.out.println("Choose another number");
            num2 = Double.parseDouble(stringNum2);
            
        //call simpleCalculator
            SimpleCalculator my = new SimpleCalculator();
                //System.out.println(my.SimpleCalculator(num1, num2,);
            if (operator == "a"){
                sum = my.add(num1, num2);
            }
            if (operator == "s"){
                sum = my.subtract(num1, num2);
            }
            if (operator == "d") {
                sum = my.divide(num1, num2);
            }
            if (operator == "m") {
                sum = my.multiply(num1, num2);
            }
            
           System.out.println(sum);
            
        //ask user if they want to continue
//            System.out.println("Do you want to continue (y/n)?");
//            stringUserInput = ask.nextLine();
//                if (stringUserInput.equals("n")){
//                    System.out.println("Thanks for playing!");
//                    break;
//                }
//                else if (stringUserInput.equals("y"));
//                    
//                }
    
    
    
    }
   
}