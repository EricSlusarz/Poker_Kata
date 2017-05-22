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

        HandRankings WhitePlayerHandEvaluator = new HandRankings();
        HandRankings BlackPlayerHandEvaluator = new HandRankings();

        for(int i = 0; i < numberOfRounds;i++){
        match.playARound(deck, whitePlayersHand, blackPlayersHand, 
              WhitePlayerHandEvaluator, BlackPlayerHandEvaluator);
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

/*
A quote I made while in coding bootcamp:
To gain knowledge you need to struggle thorough the material
Knowledge can’t go beyond your experience (i.e. the struggle)
Study, watch, learn, collaborate, and code (i.e. the experience)
Believe what you do makes a difference. It does.

Thanks for your time and consideration.
*/