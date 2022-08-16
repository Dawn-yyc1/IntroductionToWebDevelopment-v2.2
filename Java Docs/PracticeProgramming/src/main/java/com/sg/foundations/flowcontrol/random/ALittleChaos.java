/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.flowcontrol.random;

import java.util.Random;

/**
 *
 * @author pisce
 */
public class ALittleChaos {
    public static void main(String[] args) {
        
        Random randomizer = new Random();
        
        System.out.println("Random can make integers: " + randomizer.nextInt());
        System.out.println("Or a double: " + randomizer.nextDouble());
        System.out.println("Or even a boolean: " + randomizer.nextBoolean());
        
        int num = randomizer.nextInt(100);
        
        System.out.println("You can store a randomized result: " + num);
        System.out.println("And use it over and over again: " + num + ", " + num);
        System.out.println("Or just keep generating new values");
        System.out.println("Here's a bunch of number from 0 - 100: ");
        /*
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        */
        
       /*
        System.out.println(randomizer.nextInt(51) + 50);
        System.out.println(randomizer.nextInt(51) + 50);
        System.out.println(randomizer.nextInt(51) + 50);
        System.out.println(randomizer.nextInt(51) + 50);
        System.out.println(randomizer.nextInt(51) + 50);
        */
        
        
        System.out.println(randomizer.nextDouble()+2 );
        System.out.println(randomizer.nextDouble()+2);
        System.out.println(randomizer.nextDouble() +2);
        System.out.println(randomizer.nextBoolean() );
        System.out.println(randomizer.nextBoolean() );
        System.out.println(randomizer.nextBoolean() );
        System.out.println(randomizer.nextBoolean() );
        
    }      
}
/*
Q: What happens when you change randomizer.nextInt(51) + 50
A: The range of the random numbers produced becomes 
    50 to 100 (inclusive) instead of from 0-100(inclusive). 
    The method generates a random number from 0 to 50 but adding 50 to
    the number generated will give us a range of numbers from 50 to 100.

Q: Can you include random numbers in a math statement?
A: Yes, random numbers can be used in math statements. They are handy 
   for building games such as dice or cards.

I tried using the random generator with the number types of nextDouble()
and nextBoolean(). These constructs do not give a range of numbers 
like the nextInt() construct when you put a number in the parentheses.
I suppose if you need more than more than 1 random number you may have
to write a loop.
The nextDouble() gives a decimal number that is between 0 and less 
than 1. I could add a number outside of the parentheses if I wanted a 
larger number. For example, I could +2 and I would get a decimal 
number less than 3. 
The nextBoolean() constructs only returns true or false.

*/