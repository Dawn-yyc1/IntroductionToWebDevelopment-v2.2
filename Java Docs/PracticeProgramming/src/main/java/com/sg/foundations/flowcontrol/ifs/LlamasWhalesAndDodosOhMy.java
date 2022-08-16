/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.flowcontrol.ifs;

/**
 *
 * @author pisce
 */
public class LlamasWhalesAndDodosOhMy {
    public static void main(String[] args) {
        int llamas = 200; //changed from 20 to 200
        int whales = 15; 
        int dodos = 0;
        
        if(dodos > 0){
            System.out.println("Egads, I thought dodos were extinct!");
        }
        if(dodos < 0){
            System.out.println("Hold on, how can we have NEGATIVE dodos??!");
        }
        if(llamas > whales){
            System.out.println("Whales may be bigger, but llamas are better, ha!");
        }
        if(llamas <= whales){
            System.out.println("Aw man, brawn over brains I guess. Whales beat llamas.");
        }
        System.out.println("There's been a huge increase in the dodo population via cloning!");
        dodos +=100;
        
        if((whales + llamas) < dodos) { 
            System.out.println("I never thought I'd see the day when dodos rules the earth.");
        }
        
        if((llamas > whales) && (llamas > dodos)) {
            System.out.println("I don't know how, but the llamas have come out ahead! Sneaky!");
        }
    }
}
//I changed the number of llamas to 200 so that the last line will be true. 
//Dodos increased from 0 to 100 therefore if the number of llamas increase 
//to greater than 100, it will make the last line true and therefore it 
//should print out.