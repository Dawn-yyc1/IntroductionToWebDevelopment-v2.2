/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawnc.javamilestone2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author pisce
 */
public class StateCapitals_1 {
    public static void main(String[] args) {
        Map<String, String> cap = new HashMap<>();
        
        //adding key/value pairs to HashMap
        cap.put("Alabama", "Montgomery");
        cap.put("Alaska", "Juneau");
        cap.put("Arizona", "Phoenix");
        cap.put("Arkansa", "Little Rock");
        
        //display State names
        System.out.println("====  States ====");
        
        Set<String> keys = cap.keySet();       
        for (String k : keys) {   
            System.out.println(k);
        }
              
        //display Capital names
        System.out.println("==== Capitals ====");
        
        Collection<String> capValues = cap.values();
        for(String t : capValues) {
            System.out.println(t);
        }
        
        //display State/Capital pairs
        System.out.println("=== State/Capital Pairs ==");
        
             
        for(String currentKey : keys) {
            String currentCap = cap.get(currentKey);
            System.out.println(currentKey + " - " + currentCap);
        }
        
        
    }
}
