/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.flowcontrol.fors;

/**
 *
 * @author pisce
 */
import java.util.Scanner;
public class TraditionalFizzBuzz {
    public static void main(String[] args) {
        
        //declare variables
       int userInput;
        
        //get input
       Scanner sc = new Scanner(System.in);

            String stringUserInput = "";
            
            System.out.println("How many units of fizzing and buzzing do you need in your life?");
            stringUserInput = sc.nextLine();                     
        
            userInput = Integer.parseInt(stringUserInput);

        //for loop for input
          for (int i = 0; i <= userInput; i++) {
                              
            if(((i % 3) == 0) && ((i % 5) == 0)){
               System.out.println(i + " fizz buzz");
                }  
                else if(i % 3 == 0){
                     System.out.println(i + " fizz");                            
                        }else if ((i % 5) == 0){
                          System.out.println(i + " buzz");
                         }else{
                           System.out.println(i);
                            }  
              
            }            
           System.out.println("Tradition!!!");          
    }
       
      
    }
    
    /*
        I thought i needed a nested for loop but that is incorrect becuase then
        I would 2 different sets of numbers.
    
     */
        
       
 
        


