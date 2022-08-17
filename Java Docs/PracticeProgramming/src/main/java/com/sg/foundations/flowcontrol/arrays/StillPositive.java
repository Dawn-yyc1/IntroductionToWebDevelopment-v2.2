/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.flowcontrol.arrays;

/**
 *
 * @author pisce
 */
public class StillPositive {
    public static void main(String[] args) {
        
        int[] numbers = { 389, -447, 26, -485, 712, -884, 94, -64, 868, -776, 227, -744, 422, -109, 259, -500, 278, -219, 799, -311};
        
        System.out.println("Gotta stay positive...! " ); //putting this with
                                                         //the number statement makes 
                                                         //print out 10 times
        
        for (int i = 0; i < numbers.length ; i++) {
            if(numbers[i] > 0){
             
            System.out.print(numbers[i] + " ");
                
            }//
        }
        
        
    }//
    
}
/* 
be mindful of where statements are placed...it creates different results!!
Putting the System.out.print(numbers[i] + " "); in the spots with the // gives 
negative answers. 

*/