
package pokerkata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class DeckOfCards {
   List<String> packOfCards;

    protected List makeANewDeck(){
           System.out.println("Add all the cards back together and "
                   + "shuffle the deck.\n");
       packOfCards = new ArrayList<>(Arrays.asList(
            "2S","2C","2D","2H",
            "3S","3C","3D","3H",
            "4S","4C","4D","4H",
            "5S","5C","5D","5H",
            "6S","6C","6D","6H",
            "7S","7C","7D","7H",
            "8S","8C","8D","8H",
            "9S","9C","9D","9H",
            "TS","TC","TD","TH",
            "JS","JC","JD","JH",
            "QS","QC","QD","QH",
            "KS","KC","KD","KH",
            "AS","AC","AD","AH"));
        Collections.shuffle(packOfCards);
        printOutCardsInDeck();        
     return packOfCards;   
    }
    public String drawOneCard(){
        return packOfCards.remove(0);
    }

    public void printOutCardsInDeck() {
        System.out.println("Here are the "+packOfCards.size()+" cards left in the deck.");
        System.out.println(packOfCards + "\n");
    }    

}
