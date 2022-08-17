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
public class SpringForwardFallBack {
    public static void main(String[] args) {
        
        System.out.println("It's Spring...!");
        for(int i =0; i < 10; i++) {
            System.out.println(i + ", ");
        }
                
         System.out.println("\nOh no, it's fall...");       
         for(int i = 10; i > 1; i--) {
             System.out.println(i + ", ");
         }  
                
    }
}


/*
The spring loop range is 0 to 9. The fall loop range is from 10 to 2.

I am not quite sure I understand the question completely. I assume it 
wants me to make the first loop count down by only changing the 
initializer. I could change it to -10 and then counts from -10 to 9. 
Not sure this is correct though.

*/