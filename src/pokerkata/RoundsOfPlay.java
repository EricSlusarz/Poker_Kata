
package pokerkata;

import java.util.InputMismatchException;
import java.util.Scanner;

class RoundsOfPlay {

    int askNumberOfRoundsToPlay() {
        
       Scanner in = new Scanner(System.in);
       
       int numberOfRounds = 0;
       
       do{
           try{
       System.out.println("How many rounds of poker would you like to play?");
       numberOfRounds = in.nextInt();
       return numberOfRounds;
           } catch (InputMismatchException e){
               System.out.println("Invalid number of rounds. ");
           }
           in.next();
       }while(numberOfRounds <= 0);
    return numberOfRounds;   
    } 
}
