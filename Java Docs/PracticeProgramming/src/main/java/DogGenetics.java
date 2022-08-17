
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pisce
 */
public class DogGenetics {
    
    public static void main(String[] args) {
        
        String userInput;
        
        
        Scanner dog = new Scanner(System.in);
        Random rGen = new Random();
        
        int myDog1 = rGen.nextInt(100);
        int myDog2 = rGen.nextInt(100);
        int myDog3 = rGen.nextInt(100);
        int myDog4 = rGen.nextInt(100);
        int myDog5 = rGen.nextInt(100);
        
        
                
        //int sum = (100 - (myDog1 + myDog2 + myDog3 + myDog4 + myDog5)) ;
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
        arr[i] = rGen.nextInt(100);
            System.out.println(arr[i]);
        }
        
        
        
        System.out.println("What is your dog's name? ");
        userInput = dog.nextLine();
        
        System.out.println("Well the, I have this highly reliable report on " + userInput+"'s prestigious background right here.\n");
        
        System.out.println(userInput +" is:");
        
        System.out.println(myDog1 + "%" + " St. Bernard");
        System.out.println(myDog2 + "%" + " Chihuahua");
        System.out.println(myDog3 + "%" + " Dramatic RedNosed Asian Pug");
        System.out.println(myDog4 + "%" + " Common Cur");
        System.out.println(myDog5 + "%" + " King Doberman\n");
        
        System.out.println("Wow, that's QUITE the dog!");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
