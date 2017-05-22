
package pokerkata;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HandOfFiveCardsTest {
    
    private HandOfFiveCards instance;
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("----Start of Hand Of Five  Test----");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("----End of Hand Of Five Test----");
    }
    
    @Before
    public void setUp(){
    instance = new HandOfFiveCards();    
    }
    
    @Test
    public void testGetCounter() {
        int expResult = 0;
        int result = instance.getCounter();
        assertEquals("Error: Excepted 0",expResult, result);
    }

    @Test
    public void testMakeANewHand_CheckForNumberTwo() {
        instance.makeANewHand("AS", "9S", "2H", "QH", "7D");
        assertTrue(instance.getSortedHand().size()==5);
        assertTrue("Error: Expecting first card's value to be \"2\"",instance.getSortedHand().contains(2));
    }

    @Test
    public void testMakeANewHand_CheckForNumberAssingedToAce() {
        instance.makeANewHand("AS", "9S", "2H", "QH", "7D");
        assertTrue(instance.getSortedHand().size()==5);
        assertTrue("Error: Expecting last card's value to be \"14\"",instance.getSortedHand().contains(14));
    }
    
    @Test
    public void testGetFirstCardsuit() {
        instance.makeANewHand("AS", "9S", "2H", "QH", "7D");        
        String result = instance.getFirstCardsuit();
        assertEquals("Error: First card suit should be \"S\"","S", result);
    }

    @Test
    public void testGetSecondCardsuit() {
        instance.makeANewHand("AS", "5C", "2H", "QH", "7D");        
        String result = instance.getSecondCardsuit();
        assertEquals("Error: Second card suit should be \"C\"","C", result);
    }

    @Test
    public void testGetThirdCardsuit() {
        instance.makeANewHand("AS", "9S", "2H", "QH", "7D");        
        String result = instance.getThirdCardsuit();
        assertEquals("Error: Third card suit should be \"H\"","H", result);
    }

    @Test
    public void testGetFourthCardsuit() {
        instance.makeANewHand("AS", "9S", "2H", "QH", "7D");        
        String result = instance.getFourthCardsuit();
        assertEquals("Error: Fourth card suit should be \"H\"","H", result);
    }

    @Test
    public void testGetFifthCardsuit() {
        instance.makeANewHand("AS", "9S", "2H", "QH", "7D");        
        String result = instance.getFifthCardsuit();    
        assertEquals("Error: Fifth card suit should be \"D\"","D", result);
    }
}
