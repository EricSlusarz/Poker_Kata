
package pokerkata;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TieBreakerEvaluationTest {
    
    private HandOfFiveCards blackHand;
    private HandOfFiveCards whiteHand;
    private HandRankings tieBreakerFor;
    private TieBreakerEvaluation instance;
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("----Start of Tie Breaker Evaluation Test----");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("----End of Tie Breaker Evaluation Test----");
    }
    
    @Before
    public void setUp(){
        blackHand = new HandOfFiveCards();
        whiteHand = new HandOfFiveCards();
        tieBreakerFor = new HandRankings();
        instance = new TieBreakerEvaluation();
    }
    
    @Test
    public void testCompareTiedStraightFlushHands() {
        blackHand.makeANewHand("TS","JS","QS","KS","AS");
        whiteHand.makeANewHand("9S","TS","JS","QS","KS");
        tieBreakerFor.setScoreOfHand(9);
        boolean expResult = true; //Since true means Black Wins
        boolean result = instance.compareTiedHands(blackHand, whiteHand, tieBreakerFor);
        assertEquals("Black Should win with a Straight Flush",expResult, result);     
    }

    @Test
    public void testCompareTiedFourOfAKindHands() {
        blackHand.makeANewHand("TD","TC","TS","TH","2S");
        whiteHand.makeANewHand("9d","9H","9C","9S","KS");
        tieBreakerFor.setScoreOfHand(8);
        boolean expResult = true; //Since true means Black Wins
        boolean result = instance.compareTiedHands(blackHand, whiteHand, tieBreakerFor);
        assertEquals("Black Should win with a Four of A Kind Hand",expResult, result);     
    }
        
    @Test
    
    public void testCompareTiedFullHouseHands() {
        blackHand.makeANewHand("JS","JD","KC","KS","KD");
        whiteHand.makeANewHand("5C","5S","3D","3C","3S");
        tieBreakerFor.setScoreOfHand(7);
        boolean expResult = true; //Since true means Black Wins
        boolean result = instance.compareTiedHands(blackHand, whiteHand, tieBreakerFor);
        assertEquals("Black Should win with a Full House",expResult, result);     
    }    

    @Test
    public void testCompareTiedFlushHands() {
        blackHand.makeANewHand("2S","JS","QS","5S","AS");
        whiteHand.makeANewHand("9D","6D","JD","2D","KD");
        tieBreakerFor.setScoreOfHand(6);
        boolean expResult = true; //Since true means Black Wins
        boolean result = instance.compareTiedHands(blackHand, whiteHand, tieBreakerFor);
        assertEquals("Black Should win with a Flush",expResult, result);     
    }    
    @Test
    public void testCompareTiedStraightHands() {
        blackHand.makeANewHand("7D","8S","9D","5C","6S");
        whiteHand.makeANewHand("6D","5S","4C","3C","2S");
        tieBreakerFor.setScoreOfHand(5);
        boolean expResult = true; //Since true means Black Wins
        boolean result = instance.compareTiedHands(blackHand, whiteHand, tieBreakerFor);
        assertEquals("Black Should win with a Straight",expResult, result);     
    }    
    @Test
    public void testCompareTiedThreeOfAKindHands() {
        blackHand.makeANewHand("9S","9D","9C","2S","KS");
        whiteHand.makeANewHand("3D","3C","3S","5S","6S");
        tieBreakerFor.setScoreOfHand(4);
        boolean expResult = true; //Since true means Black Wins
        boolean result = instance.compareTiedHands(blackHand, whiteHand, tieBreakerFor);
        assertEquals("Black Should win with a three of a kind",expResult, result);     
    }    

    @Test
    public void testCompareTiedTwoPairHands() {
        blackHand.makeANewHand("TS","TD","AD","AS","5S");
        whiteHand.makeANewHand("TC","TH","AH","AC","4S");
        tieBreakerFor.setScoreOfHand(3);
        boolean expResult = true; //Since true means Black Wins
        boolean result = instance.compareTiedHands(blackHand, whiteHand, tieBreakerFor);
        assertEquals("Black Should win with a Two Pair",expResult, result);     
    }

    @Test
    public void testCompareTiedOnePairHands() {
        blackHand.makeANewHand("KS","KD","AS","5S","JD");
        whiteHand.makeANewHand("KH","KC","QS","QC","4S");
        tieBreakerFor.setScoreOfHand(2);
        boolean expResult = true; //Since true means Black Wins
        boolean result = instance.compareTiedHands(blackHand, whiteHand, tieBreakerFor);
        assertEquals("Black Should win with a One Pair",expResult, result);     
    }

    @Test
    public void testCompareTiedHighCardHands() {
        blackHand.makeANewHand("AS","QD","JH","5D","4C");
        whiteHand.makeANewHand("AC","QH","JD","5S","3C");
        tieBreakerFor.setScoreOfHand(1);
        boolean expResult = true; //Since true means Black Wins
        boolean result = instance.compareTiedHands(blackHand, whiteHand, tieBreakerFor);
        assertEquals("Black Should win with a High Card",expResult, result);     
    }
}
