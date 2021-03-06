
package pokerkata;

class ReadOutOfHandAndRanking {

    
    
public void printPlayersHandAndRanking(HandRankings evaluatedHand, 
                                       HandOfFiveCards playersHand) {
        System.out.print(playersHand.getPlayer()+" Player's Hand: ");
        playersHand.printOutHand();        
        System.out.println("Hand Ranking: "+ evaluatedHand.getNameOfHand());        
    }  

    public void printOutWinningHandandPlayer() {
        System.out.println("Results: ");
        System.out.println("There was a tie! Let's go to the tie breaker!");
    }

    public void printOutWinningHandandPlayer(HandRankings nameOfWinningHand, HandOfFiveCards winningName) {
        System.out.println("Results: ");
        System.out.println(winningName.getPlayer()+ " Wins with a " 
                           +nameOfWinningHand.getNameOfHand() + "!\n");
    }

    public void tieBreakerWinngingPrintOut(HandRankings nameOfWinngingHand, HandOfFiveCards winningName) {
        System.out.println(winningName.getPlayer()+ " Wins After Tie Breaker with a "
                           +nameOfWinngingHand.getNameOfHand()+ "!\n");
    }
}
