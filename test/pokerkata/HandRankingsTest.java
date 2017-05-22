 
package pokerkata;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HandRankingsTest {
    
    private HandOfFiveCards hand;
    private HandRankings instance;
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("----Start of Hand Rankings Test----");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("----End of Hand Rankings Test----"); 
    }
    @Before
    public void setUp(){
         hand = new HandOfFiveCards();
         instance = new HandRankings();   
    }

    @Test
    public void testEvaluatePokerHand() {
        DeckOfCards deck = new DeckOfCards();
        deck.makeANewDeck();
        hand.makeANewHand(deck.drawOneCard(),
                          deck.drawOneCard(),
                          deck.drawOneCard(),
                          deck.drawOneCard(),
                          deck.drawOneCard());
        instance.evaluatePokerHand(hand);
        assertNotNull(deck);
        assertNotNull(hand);
        assertFalse(hand.getSortedHand().isEmpty());
    }

    @Test
    public void testEvaluateForOnePair() {
        hand.makeANewHand("2S","3C","5D","AC","AH");
        instance.evaluateForOnePair(hand);
        assertEquals("Error: High Card scoreOfHand Should be 2",2, instance.getScoreOfHand());
        assertEquals("Error: High Card nameOfHand Should be \"One Pair\".", "One Pair", instance.getNameOfHand());
    }

    @Test
    public void testEvaluateHandForTwoPairs() {
        hand.makeANewHand("2S","5C","5D","AC","AH");        
        instance.evaluateHandForTwoPairs(hand);
        assertEquals("Error: High Card scoreOfHand Should be 3",3, instance.getScoreOfHand());
        assertEquals("Error: High Card nameOfHand Should be \"Two Pair\".", "Two Pair", instance.getNameOfHand());
    }

    @Test
    public void testEvaluateHandForThreeOfAKind() {
        hand.makeANewHand("2S","5C","AD","AC","AH");        
        instance.evaluateHandForThreeOfAKind(hand);
        assertEquals("Error: High Card scoreOfHand Should be 4",4, instance.getScoreOfHand());
        assertEquals("Error: High Card nameOfHand Should be \"Three of a Kind\".", "Three of a kind", instance.getNameOfHand());
    }

    @Test
    public void testEvaluateHandForStraight() {
        hand.makeANewHand("TS","JC","QD","KC","AH");        
        instance.evaluateHandForStraight(hand);
        assertEquals("Error: High Card scoreOfHand Should be 5",5, instance.getScoreOfHand());
        assertEquals("Error: High Card nameOfHand Should be \"Straight\".", "Straight", instance.getNameOfHand());
    }

    @Test
    public void testEvaluateHandForFlush() {
        hand.makeANewHand("2H","7H","4H","KH","JH");        
        instance.evaluateHandForFlush(hand);
        assertEquals("Error: High Card scoreOfHand Should be 6",6, instance.getScoreOfHand());
        assertEquals("Error: High Card nameOfHand Should be \"Flush\".", "Flush", instance.getNameOfHand());
    }

    @Test
    public void testEvaluateHandForFullHouse() {
        hand.makeANewHand("2H","2S","4H","4C","4D");        
        instance.evaluateHandForFullHouse(hand);
        assertEquals("Error: High Card scoreOfHand Should be 7",7, instance.getScoreOfHand());
        assertEquals("Error: High Card nameOfHand Should be \"Full House\".", "Full House", instance.getNameOfHand());
    }

    @Test
    public void testEvaluateHandForFourOfAKind() {
        hand.makeANewHand("2H","4S","4H","4C","4D");        
        instance.evaluateHandForFourOfAKind(hand);
        assertEquals("Error: High Card scoreOfHand Should be 8",8, instance.getScoreOfHand());
        assertEquals("Error: High Card nameOfHand Should be \"Four of A Kind\".", "Four of A Kind", instance.getNameOfHand());
    }

    @Test
    public void testEvaluateHandForStraightFlush() {
        hand.makeANewHand("6D","7D","8D","9D","TD");        
        instance.evaluateHandForStraightFlush(hand);
        assertEquals("Error: High Card scoreOfHand Should be 9",9, instance.getScoreOfHand());
        assertEquals("Error: High Card nameOfHand Should be \"Straight Flush\".", "Straight Flush", instance.getNameOfHand());
    }
}
