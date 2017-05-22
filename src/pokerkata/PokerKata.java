package pokerkata;
/**
 * @author Eric Slusarz 
 * 
 * Poker Kata For Manifest Solutions
 */
public class PokerKata {
    
    public static void main(String[] args) {
        PokerGame match = new PokerGame();
        
        RoundsOfPlay promt = new RoundsOfPlay();        
        int numberOfRounds = promt.askNumberOfRoundsToPlay();
        
        DeckOfCards deck = new DeckOfCards();
        HandOfFiveCards whitePlayersHand = new HandOfFiveCards();
        HandOfFiveCards blackPlayersHand = new HandOfFiveCards();

        HandRankings whitePlayerHandEvaluator = new HandRankings();
        HandRankings blackPlayerHandEvaluator = new HandRankings();

        for(int i = 0; i < numberOfRounds;i++){
        match.playARound(deck, whitePlayersHand, blackPlayersHand, 
              whitePlayerHandEvaluator, blackPlayerHandEvaluator);
        }       
    }
}

/*
Notes to self: 
Subclass more
Make Classes Smaller
Don't use switch statement next time
Try to use less if else
Setup methods to unit test easier
Pass less parameters next time
*/