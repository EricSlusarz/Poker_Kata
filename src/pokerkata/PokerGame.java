
package pokerkata;

class PokerGame {

    void playARound(DeckOfCards deck, HandOfFiveCards whitePlayersHand, HandOfFiveCards blackPlayersHand, 
                    HandRankings whitePlayerHandEvaluator, HandRankings blackPlayerHandEvaluator) {
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
        
        whitePlayerHandEvaluator.evaluatePokerHand(whitePlayersHand);
        blackPlayerHandEvaluator.evaluatePokerHand(blackPlayersHand);
        
        declareWinner(whitePlayerHandEvaluator, blackPlayerHandEvaluator, blackPlayersHand, whitePlayersHand);
        
        deck.printOutCardsInDeck();
    }
    private void declareWinner(HandRankings whitePlayerHandEvaluator, HandRankings blackPlayerHandEvaluator, 
                               HandOfFiveCards blackPlayersHand, HandOfFiveCards whitePlayersHand) {
        
        ReadOutOfHandAndRanking readOut = new ReadOutOfHandAndRanking();

        readOut.printPlayersHandAndRanking(whitePlayerHandEvaluator, whitePlayersHand);
        readOut.printPlayersHandAndRanking(blackPlayerHandEvaluator, blackPlayersHand);
        
        if (whitePlayerHandEvaluator.getScoreOfHand() > blackPlayerHandEvaluator.getScoreOfHand()) {
            readOut.printOutWinningHandandPlayer(whitePlayerHandEvaluator, whitePlayersHand);
        } else if (whitePlayerHandEvaluator.getScoreOfHand() < blackPlayerHandEvaluator.getScoreOfHand()) {
            readOut.printOutWinningHandandPlayer(blackPlayerHandEvaluator, blackPlayersHand);
        } else {
            readOut.printOutWinningHandandPlayer();
            
            TieBreakerEvaluation tieBreakerEvaluator = new TieBreakerEvaluation();
            
            if (tieBreakerEvaluator.compareTiedHands(blackPlayersHand, whitePlayersHand, whitePlayerHandEvaluator)){
                readOut.tieBreakerWinngingPrintOut(blackPlayerHandEvaluator, blackPlayersHand);
            } else {
                readOut.tieBreakerWinngingPrintOut(whitePlayerHandEvaluator, whitePlayersHand);
            }
        }
    }
}
