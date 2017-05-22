 
package pokerkata;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HandRankingsTest {
    
    public HandRankingsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("----Start of Hand Rankings Test----");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("----End of Hand Rankings Test----"); 
    }

    @Test
    public void testEvaluatePokerHand() {
        HandOfFiveCards hand = new HandOfFiveCards();
        DeckOfCards deck = new DeckOfCards();
        deck.makeANewDeck();
        hand.makeANewHand(deck.drawOneCard(),
                          deck.drawOneCard(),
                          deck.drawOneCard(),
                          deck.drawOneCard(),
                          deck.drawOneCard());
        HandRankings instance = new HandRankings();
        instance.evaluatePokerHand(hand);
        assertNotNull(deck);
        assertNotNull(hand);
        assertFalse(hand.getSortedHand().isEmpty());
    }

    @Test
    public void testEvaluateForOnePair() {
        HandOfFiveCards hand = new HandOfFiveCards();
        hand.makeANewHand("2S","3C","5D","AC","AH");
        HandRankings instance = new HandRankings();
        instance.evaluateForOnePair(hand);
        assertEquals("Error: High Card scoreOfHand Should be 2",2, instance.getScoreOfHand());
        assertEquals("Error: High Card nameOfHand Should be \"One Pair\".", "One Pair", instance.getNameOfHand());
    }

    @Test
    public void testEvaluateHandForTwoPairs() {
        HandOfFiveCards hand = new HandOfFiveCards();
        hand.makeANewHand("2S","5C","5D","AC","AH");        
        HandRankings instance = new HandRankings();
        instance.evaluateHandForTwoPairs(hand);
        assertEquals("Error: High Card scoreOfHand Should be 3",3, instance.getScoreOfHand());
        assertEquals("Error: High Card nameOfHand Should be \"Two Pair\".", "Two Pair", instance.getNameOfHand());
    }

    @Test
    public void testEvaluateHandForThreeOfAKind() {
        HandOfFiveCards hand = new HandOfFiveCards();
        hand.makeANewHand("2S","5C","AD","AC","AH");        
        HandRankings instance = new HandRankings();
        instance.evaluateHandForThreeOfAKind(hand);
        assertEquals("Error: High Card scoreOfHand Should be 4",4, instance.getScoreOfHand());
        assertEquals("Error: High Card nameOfHand Should be \"Three of a Kind\".", "Three of a kind", instance.getNameOfHand());
    }

    @Test
    public void testEvaluateHandForStraight() {
        HandOfFiveCards hand = new HandOfFiveCards();
        hand.makeANewHand("TS","JC","QD","KC","AH");        
        HandRankings instance = new HandRankings();
        instance.evaluateHandForStraight(hand);
        assertEquals("Error: High Card scoreOfHand Should be 5",5, instance.getScoreOfHand());
        assertEquals("Error: High Card nameOfHand Should be \"Straight\".", "Straight", instance.getNameOfHand());
    }

    @Test
    public void testEvaluateHandForFlush() {
        HandOfFiveCards hand = new HandOfFiveCards();
        hand.makeANewHand("2H","7H","4H","KH","JH");        
        HandRankings instance = new HandRankings();
        instance.evaluateHandForFlush(hand);
        assertEquals("Error: High Card scoreOfHand Should be 6",6, instance.getScoreOfHand());
        assertEquals("Error: High Card nameOfHand Should be \"Flush\".", "Flush", instance.getNameOfHand());
    }

    @Test
    public void testEvaluateHandForFullHouse() {
        HandOfFiveCards hand = new HandOfFiveCards();
        hand.makeANewHand("2H","2S","4H","4C","4D");        
        HandRankings instance = new HandRankings();
        instance.evaluateHandForFullHouse(hand);
        assertEquals("Error: High Card scoreOfHand Should be 7",7, instance.getScoreOfHand());
        assertEquals("Error: High Card nameOfHand Should be \"Full House\".", "Full House", instance.getNameOfHand());
    }

    @Test
    public void testEvaluateHandForFourOfAKind() {
        HandOfFiveCards hand = new HandOfFiveCards();
        hand.makeANewHand("2H","4S","4H","4C","4D");        
        HandRankings instance = new HandRankings();
        instance.evaluateHandForFourOfAKind(hand);
        assertEquals("Error: High Card scoreOfHand Should be 8",8, instance.getScoreOfHand());
        assertEquals("Error: High Card nameOfHand Should be \"Four of A Kind\".", "Four of A Kind", instance.getNameOfHand());
    }

    @Test
    public void testEvaluateHandForStraightFlush() {
        HandOfFiveCards hand = new HandOfFiveCards();
        hand.makeANewHand("6D","7D","8D","9D","TD");        
        HandRankings instance = new HandRankings();
        instance.evaluateHandForStraightFlush(hand);
        assertEquals("Error: High Card scoreOfHand Should be 9",9, instance.getScoreOfHand());
        assertEquals("Error: High Card nameOfHand Should be \"Straight Flush\".", "Straight Flush", instance.getNameOfHand());
    }
}
