
package pokerkata;

class PokerGame {

    void playARound(DeckOfCards deck, HandOfFiveCards whitePlayersHand, HandOfFiveCards blackPlayersHand, 
                    HandRankings WhitePlayerHandEvaluator, HandRankings BlackPlayerHandEvaluator) {
    if((blackPlayersHand.counter%5)==0) {  
        deck.makeANewDeck();
    }
    
        whitePlayersHand.makeANewHand(deck.drawOneCard(),
                                      deck.drawOneCard(),
                                      deck.drawOneCard(),
                                      deck.drawOneCard(),
                                      deck.drawOneCard());
        
        blackPlayersHand.makeANewHand(deck.drawOneCard(),
                                      deck.drawOneCard(),
                                      deck.drawOneCard(),
                                      deck.drawOneCard(),
                                      deck.drawOneCard());
        
        WhitePlayerHandEvaluator.evaluatePokerHand(whitePlayersHand);
        BlackPlayerHandEvaluator.evaluatePokerHand(blackPlayersHand);
        
        declareWinner(WhitePlayerHandEvaluator, BlackPlayerHandEvaluator, blackPlayersHand, whitePlayersHand);
        
        deck.printOutCardsInDeck();
    }
    private void declareWinner(HandRankings WhitePlayerHandEvaluator, HandRankings BlackPlayerHandEvaluator, 
                               HandOfFiveCards blackPlayersHand, HandOfFiveCards whitePlayersHand) {
        
        ReadOutOfHandAndRanking readOut = new ReadOutOfHandAndRanking();

        readOut.printPlayersHandAndRanking(WhitePlayerHandEvaluator, whitePlayersHand);
        readOut.printPlayersHandAndRanking(BlackPlayerHandEvaluator, blackPlayersHand);
        
        if (WhitePlayerHandEvaluator.getScoreOfHand() > BlackPlayerHandEvaluator.getScoreOfHand()) {
            readOut.printOutWinningHandandPlayer(WhitePlayerHandEvaluator, whitePlayersHand);
        } else if (WhitePlayerHandEvaluator.getScoreOfHand() < BlackPlayerHandEvaluator.getScoreOfHand()) {
            readOut.printOutWinningHandandPlayer(BlackPlayerHandEvaluator, blackPlayersHand);
        } else {
            readOut.printOutWinningHandandPlayer();
            
            TieBreakerEvaluation tieBreakerEvaluator = new TieBreakerEvaluation();
            
            if (tieBreakerEvaluator.compareTiedHands(blackPlayersHand, whitePlayersHand, WhitePlayerHandEvaluator)){
                readOut.tieBreakerWinngingPrintOut(BlackPlayerHandEvaluator, blackPlayersHand);
            } else {
                readOut.tieBreakerWinngingPrintOut(WhitePlayerHandEvaluator, whitePlayersHand);
            }
        }
    }
}
