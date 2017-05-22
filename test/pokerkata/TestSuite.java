
package pokerkata;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    DeckOfCardsTest.class,
    HandOfFiveCardsTest.class,
    HandRankingsTest.class,
    TieBreakerEvaluationTest.class,
})
public class TestSuite {
}
