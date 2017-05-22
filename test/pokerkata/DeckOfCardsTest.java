
package pokerkata;

import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeckOfCardsTest {
    
    private DeckOfCards instance;
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("----Start of Deck Of Cards Test----");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("----End of Deck Of Cards Test----");
    }
    
    @Before
    public void setUp(){
        instance = new DeckOfCards();
    }
    
    @Test
    public void testDeckHas52Cards() {
        List result = instance.makeANewDeck();
        int NumberOfCardsInDeck = result.size();               
        assertEquals("Error: There Should be 52 Cards",52, NumberOfCardsInDeck);
    }

    @Test
    public void testMakeANewDeck_CheckFirstCard() {
        List result = instance.makeANewDeck();
        Object FirstCard = result.get(0);
        assertNotNull("Error: first card should not be null",FirstCard);
    }    
  
    @Test
    public void testMakeANewDeck_CheckLastCard() {
        List result = instance.makeANewDeck();
        Object LastCard = result.get(51);
        assertNotNull("Error: last card should not be null",LastCard);
    }    
    
    @Test
    public void testShuffleAndDraw() {
        List result = instance.makeANewDeck();
        String randomcard = instance.drawOneCard();
        assertNotNull("Error: Randomly drawn card should not be null",randomcard);
    }

    @Test
    public void testCompareFirstCardThroughTwoMethods() {
        List result = instance.makeANewDeck();
        Object firstcardInDeck = result.get(0);
        String cardUsingdrawOneCardMethod = instance.drawOneCard();
        assertSame("Error: both method calls should return the same card",
                   firstcardInDeck,cardUsingdrawOneCardMethod);
    }    
}
