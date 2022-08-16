/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.flowcontrol.whiles;

import java.util.Random;

/**
 *
 * @author pisce
 */
public class LazyTeenager {
    
    public static void main(String[] args) {
        
        int parentYells = 0;
       
                
        Random cleanRoom = new Random();
        int teen = cleanRoom.nextInt(8);
        
        do {
           System.out.println("Clean your room!!" );
           parentYells++;
        } while (parentYells <=7 ); 
           
          System.out.print("x" + parentYells );
          
            
        }
        
        
        
        
        
    }

