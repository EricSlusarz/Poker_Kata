
package pokerkata;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TieBreakerEvaluationTest {
    
    public TieBreakerEvaluationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("----Start of Tie Breaker Evaluation Test----");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("----End of Tie Breaker Evaluation Test----");
    }

    @Test
    public void testCompareTiedStraightFlushHands() {
        HandOfFiveCards blackHand = new HandOfFiveCards();
        blackHand.makeANewHand("TS","JS","QS","KS","AS");
        HandOfFiveCards whiteHand = new HandOfFiveCards();
        whiteHand.makeANewHand("9S","TS","JS","QS","KS");
        HandRankings tieBreakerFor = new HandRankings();
        TieBreakerEvaluation instance = new TieBreakerEvaluation();
        tieBreakerFor.setScoreOfHand(9);
        boolean expResult = true; //Since true means Black Wins
        boolean result = instance.compareTiedHands(blackHand, whiteHand, tieBreakerFor);
        assertEquals("Black Should win with a Straight Flush",expResult, result);     
    }

    @Test
    public void testCompareTiedFourOfAKindHands() {
        HandOfFiveCards blackHand = new HandOfFiveCards();
        blackHand.makeANewHand("TD","TC","TS","TH","2S");
        HandOfFiveCards whiteHand = new HandOfFiveCards();
        whiteHand.makeANewHand("9d","9H","9C","9S","KS");
        HandRankings tieBreakerFor = new HandRankings();
        TieBreakerEvaluation instance = new TieBreakerEvaluation();
        tieBreakerFor.setScoreOfHand(8);
        boolean expResult = true; //Since true means Black Wins
        boolean result = instance.compareTiedHands(blackHand, whiteHand, tieBreakerFor);
        assertEquals("Black Should win with a Four of A Kind Hands",expResult, result);     
    }
        
    @Test
    
    public void testCompareTiedFullHouseHands() {
        HandOfFiveCards blackHand = new HandOfFiveCards();
        blackHand.makeANewHand("JS","JD","KC","KS","KD");
        HandOfFiveCards whiteHand = new HandOfFiveCards();
        whiteHand.makeANewHand("5C","5S","3D","3C","3S");
        HandRankings tieBreakerFor = new HandRankings();
        TieBreakerEvaluation instance = new TieBreakerEvaluation();
        tieBreakerFor.setScoreOfHand(7);
        boolean expResult = true; //Since true means Black Wins
        boolean result = instance.compareTiedHands(blackHand, whiteHand, tieBreakerFor);
        assertEquals("Black Should win with a Full House",expResult, result);     
    }    

    @Test
    public void testCompareTiedFlushHands() {
        HandOfFiveCards blackHand = new HandOfFiveCards();
        blackHand.makeANewHand("2S","JS","QS","5S","AS");
        HandOfFiveCards whiteHand = new HandOfFiveCards();
        whiteHand.makeANewHand("9D","6D","JD","2D","KD");
        HandRankings tieBreakerFor = new HandRankings();
        TieBreakerEvaluation instance = new TieBreakerEvaluation();
        tieBreakerFor.setScoreOfHand(6);
        boolean expResult = true; //Since true means Black Wins
        boolean result = instance.compareTiedHands(blackHand, whiteHand, tieBreakerFor);
        assertEquals("Black Should win with a Flush",expResult, result);     
    }    
    @Test
    public void testCompareTiedStraightHands() {
        HandOfFiveCards blackHand = new HandOfFiveCards();
        blackHand.makeANewHand("7D","8S","9D","5C","6S");
        HandOfFiveCards whiteHand = new HandOfFiveCards();
        whiteHand.makeANewHand("6D","5S","4C","3C","2S");
        HandRankings tieBreakerFor = new HandRankings();
        TieBreakerEvaluation instance = new TieBreakerEvaluation();
        tieBreakerFor.setScoreOfHand(5);
        boolean expResult = true; //Since true means Black Wins
        boolean result = instance.compareTiedHands(blackHand, whiteHand, tieBreakerFor);
        assertEquals("Black Should win with a Straight",expResult, result);     
    }    
    @Test
    public void testCompareTiedThreeOfAKindHands() {
        HandOfFiveCards blackHand = new HandOfFiveCards();
        blackHand.makeANewHand("9S","9D","9C","2S","KS");
        HandOfFiveCards whiteHand = new HandOfFiveCards();
        whiteHand.makeANewHand("3D","3C","3S","5S","6S");
        HandRankings tieBreakerFor = new HandRankings();
        TieBreakerEvaluation instance = new TieBreakerEvaluation();
        tieBreakerFor.setScoreOfHand(4);
        boolean expResult = true; //Since true means Black Wins
        boolean result = instance.compareTiedHands(blackHand, whiteHand, tieBreakerFor);
        assertEquals("Black Should win with a three of a kind",expResult, result);     
    }    

    @Test
    public void testCompareTiedTwoPairHands() {
        HandOfFiveCards blackHand = new HandOfFiveCards();
        blackHand.makeANewHand("TS","TD","AD","AS","5S");
        HandOfFiveCards whiteHand = new HandOfFiveCards();
        whiteHand.makeANewHand("TC","TH","AH","AC","4S");
        HandRankings tieBreakerFor = new HandRankings();
        TieBreakerEvaluation instance = new TieBreakerEvaluation();
        tieBreakerFor.setScoreOfHand(3);
        boolean expResult = true; //Since true means Black Wins
        boolean result = instance.compareTiedHands(blackHand, whiteHand, tieBreakerFor);
        assertEquals("Black Should win with a Two Pair",expResult, result);     
    }

    @Test
    public void testCompareTiedOnePairHands() {
        HandOfFiveCards blackHand = new HandOfFiveCards();
        blackHand.makeANewHand("KS","KD","AS","5S","JD");
        HandOfFiveCards whiteHand = new HandOfFiveCards();
        whiteHand.makeANewHand("KH","KC","QS","QC","4S");
        HandRankings tieBreakerFor = new HandRankings();
        TieBreakerEvaluation instance = new TieBreakerEvaluation();
        tieBreakerFor.setScoreOfHand(2);
        boolean expResult = true; //Since true means Black Wins
        boolean result = instance.compareTiedHands(blackHand, whiteHand, tieBreakerFor);
        assertEquals("Black Should win with a One Pair",expResult, result);     
    }

    @Test
    public void testCompareTiedHighCardHands() {
        HandOfFiveCards blackHand = new HandOfFiveCards();
        blackHand.makeANewHand("AS","QD","JH","5D","4C");
        HandOfFiveCards whiteHand = new HandOfFiveCards();
        whiteHand.makeANewHand("AC","QH","JD","5S","3C");
        HandRankings tieBreakerFor = new HandRankings();
        TieBreakerEvaluation instance = new TieBreakerEvaluation();
        tieBreakerFor.setScoreOfHand(1);
        boolean expResult = true; //Since true means Black Wins
        boolean result = instance.compareTiedHands(blackHand, whiteHand, tieBreakerFor);
        assertEquals("Black Should win with a High Card",expResult, result);     
    }

    @Test
    public void testNameWhiteWinnerComparingSamePositionInBothHands() {
        int i = 0;
        HandOfFiveCards blackHand = new HandOfFiveCards();
        blackHand.makeANewHand("AS","QD","JH","5D","4C");
        HandOfFiveCards whiteHand = new HandOfFiveCards();
        whiteHand.makeANewHand("AC","QH","JD","5S","3C");
        TieBreakerEvaluation tieBreakerEvaluator = new TieBreakerEvaluation();
        boolean expResult = false;
        boolean result = tieBreakerEvaluator.compareSameHandPositionForWhiteWin(blackHand, i, whiteHand);
        assertEquals("Error: Black was expected to win",expResult, result);
    }

    @Test
    public void testNameBlackWinnerComparingSamePositionInBothHands() {
       int i = 0;
        HandOfFiveCards blackHand = new HandOfFiveCards();
        blackHand.makeANewHand("AS","QD","JH","5D","4C");
        HandOfFiveCards whiteHand = new HandOfFiveCards();
        whiteHand.makeANewHand("AC","QH","JD","5S","3C");
        TieBreakerEvaluation tieBreakerEvaluator = new TieBreakerEvaluation();
        boolean expResult = true;
        boolean result = tieBreakerEvaluator.compareSameHandPositionForBlackWin(blackHand, i, whiteHand);
        assertEquals("Error: Black was expected to win",expResult, result);
    }

    @Test
    public void testCompareBothHandsAtFirstPosition() {
        int i = 0;
        HandOfFiveCards blackHand = new HandOfFiveCards();
        blackHand.makeANewHand("AS","QD","JH","5D","4C");
        HandOfFiveCards whiteHand = new HandOfFiveCards();
        whiteHand.makeANewHand("AC","QH","JD","5S","3C");
        TieBreakerEvaluation tieBreakerEvaluator = new TieBreakerEvaluation();
        boolean expResult = false;
        boolean result = tieBreakerEvaluator.compareBothHandsAtSamePosition(blackHand, i, whiteHand);
        assertEquals("Error: first position is expecting different values",expResult, result);
    }
    
    @Test
    public void testCompareBothHandsAtFifthPosition() {
        int i = 4;
        HandOfFiveCards blackHand = new HandOfFiveCards();
        blackHand.makeANewHand("AS","QD","JH","5D","4C");
        HandOfFiveCards whiteHand = new HandOfFiveCards();
        whiteHand.makeANewHand("AC","QH","JD","5S","3C");
        TieBreakerEvaluation tieBreakerEvaluator = new TieBreakerEvaluation();
        boolean expResult = true;
        boolean result = tieBreakerEvaluator.compareBothHandsAtSamePosition(blackHand, i, whiteHand);
        assertEquals("Error: first position is expecting the same values",expResult, result);
    }
}
