/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.flowcontrol.whiles;

/**
 *
 * @author pisce
 */
public class WaitAWhile {
    public static void main(String[] args) {
        
        int timeNow = 5;
        int bedTime = 12;
                
        
        while(timeNow < bedTime) {
            System.out.println("It's only " + timeNow + " o'clock!");
            System.out.println("I think I'll stay up just a liiiiitle longer...");
            timeNow++;
        }
        
        System.out.println("Oh. It's " + timeNow + " o'clock...");
        System.out.println("Guess I should go to bed...");
                
    }
}

/*
Changing the bedTime's value makes the loop count higher if the number
is l1. Changing it to a smaller number just means the loop
is shorter.

When timeNow is 11 and bedTime is 10, this is the output:

Oh. It's 11 o'clock...
Guess I should go to bed...

I thought the program would crash because condiiton is false but it executed. I guess that is what
a while loop does, it executes even is the condition is false.

Commenting out timeNow++, produced the same results as above when 
timeNow = 11 and bedTime is 10. 
When I set the original values, the program ran infinitely at 5 because
there was no instruction to increase the count from 5.

*/