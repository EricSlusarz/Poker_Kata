
package pokerkata;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class TieBreakerEvaluation{
    
   public boolean compareTiedHands(HandOfFiveCards blackHand, HandOfFiveCards whiteHand, HandRankings tieBreakerFor){
       final int sizeOfHand = blackHand.getSortedHand().size();
       
    switch(tieBreakerFor.getScoreOfHand()){    
        case 1: for(int i = sizeOfHand-1; i >= 0 ;i--){
            if(compareBothHandsAtSamePosition(blackHand, i, whiteHand)){ 
            } else{
                return compareSameHandPositionForBlackWin(blackHand, i, whiteHand);
            }  
        } return FlipCoin();
        
        case 2: ArrayList<Integer> onePairTieBreakerArrayListForBlack = new ArrayList<>();
            for(int i = 0;i < blackHand.getSortedHand().size()-1;i++){
            if(blackHand.getSortedHand().get(i).equals(blackHand.getSortedHand().get(i+1))){
              onePairTieBreakerArrayListForBlack.add(blackHand.getSortedHand().get(i));
              i = deleteMatchingPairFromArray(blackHand, i);
               } 
            }
            ArrayList<Integer> onePairTieBreakerArrayListForWhite = new ArrayList<>();
            for(int i = 0;i < whiteHand.getSortedHand().size()-1;i++){
            if(whiteHand.getSortedHand().get(i).equals(whiteHand.getSortedHand().get(i+1))){
              onePairTieBreakerArrayListForWhite.add(whiteHand.getSortedHand().get(i));
              i = deleteMatchingPairFromArray(whiteHand, i);
               }
            }

        return onePairTieBreakerComparison(onePairTieBreakerArrayListForBlack, 
                                           onePairTieBreakerArrayListForWhite, 
                                           blackHand, whiteHand);
 
        case 3: ArrayList<Integer> twoPairTieBreakerArrayListForWhite = new ArrayList<>();
            for(int i = 0;i < whiteHand.getSortedHand().size()-1;i++){
                if(whiteHand.getSortedHand().get(i).equals(whiteHand.getSortedHand().get(i+1))){
                    twoPairTieBreakerArrayListForWhite.add(whiteHand.getSortedHand().get(i));
                    i = deleteMatchingPairFromArray(whiteHand, i);
                }
            }
          ArrayList<Integer> twoPairTieBreakerArrayListForBlack = new ArrayList<>();
            for(int i = 0;i < blackHand.getSortedHand().size()-1;i++){
                if(blackHand.getSortedHand().get(i).equals(blackHand.getSortedHand().get(i+1))){
                    twoPairTieBreakerArrayListForBlack.add(blackHand.getSortedHand().get(i));
                    i = deleteMatchingPairFromArray(blackHand, i);
                }
            }  
            return TwoPairTieBreakerComparison(twoPairTieBreakerArrayListForBlack, 
                                   twoPairTieBreakerArrayListForWhite, blackHand, whiteHand);

        case 4:    
            if(compareSameHandPositionForBlackWin(blackHand, 2, whiteHand)){
                return true;
            } else if(compareSameHandPositionForWhiteWin(blackHand, 2 , whiteHand)){
                return false;
            } return FlipCoin();
                       
        case 5:  for(int i = sizeOfHand-1; i >= 0 ;i--){
            if(compareBothHandsAtSamePosition(blackHand, i, whiteHand)){
               } else {
              return compareSameHandPositionForBlackWin(blackHand, i, whiteHand);
            }  
        } return FlipCoin();
            
            
        case 6:  for(int i = sizeOfHand-1; i >= 0 ;i--){
            if(compareBothHandsAtSamePosition(blackHand, i, whiteHand)){
            } else{
              return compareSameHandPositionForBlackWin(blackHand, i, whiteHand);
            }  
        } return FlipCoin();
              
        case 7: if(compareSameHandPositionForBlackWin(blackHand, 2, whiteHand)){
            return true;
        } else if(compareSameHandPositionForWhiteWin(blackHand,  2, whiteHand)){
            return false;
        } else{
            blackHand.getSortedHand().removeIf(blackHand.getSortedHand().get(2)::equals);
            whiteHand.getSortedHand().removeIf(whiteHand.getSortedHand().get(2)::equals);
            if (compareSameHandPositionForBlackWin(blackHand, 0, whiteHand)){
              return true;
            }else if(compareSameHandPositionForWhiteWin(blackHand,  0, whiteHand)){
              return false; 
            } FlipCoin();
        }
        
        case 8:  if(compareSameHandPositionForBlackWin(blackHand, 2, whiteHand)){
                return true;
        } else if(compareSameHandPositionForWhiteWin(blackHand, 2,whiteHand)){
                return false;
        } else{
            blackHand.getSortedHand().removeIf(blackHand.getSortedHand().get(2)::equals);
            whiteHand.getSortedHand().removeIf(whiteHand.getSortedHand().get(2)::equals);
            if(compareSameHandPositionForBlackWin(blackHand, 0, whiteHand)){
                return true;
            } else{
              return FlipCoin();
            }
        }
            
        case 9: if(compareSameHandPositionForBlackWin(blackHand, 4, whiteHand)){
            return true;
        } if(compareSameHandPositionForWhiteWin(blackHand, 4, whiteHand)){
            return false;
        }
    }           return FlipCoin();
}

    public boolean compareBothHandsAtSamePosition(HandOfFiveCards blackHand, int samePosition, HandOfFiveCards whiteHand) {
        return blackHand.getSortedHand().get(samePosition).equals(whiteHand.getSortedHand().get(samePosition));
    }
    
    public boolean compareSameHandPositionForWhiteWin(HandOfFiveCards blackHand, int samePosition, HandOfFiveCards whiteHand) {
        return blackHand.getSortedHand().get(samePosition)<whiteHand.getSortedHand().get(samePosition);
    }

    public boolean compareSameHandPositionForBlackWin(HandOfFiveCards blackHand, int samePosition, HandOfFiveCards whiteHand) {
        return blackHand.getSortedHand().get(samePosition)>whiteHand.getSortedHand().get(samePosition);
    }

    public boolean onePairTieBreakerComparison(ArrayList<Integer> onePairTieBreakerArrayListForBlack, 
                                               ArrayList<Integer> onePairTieBreakerArrayListForWhite, 
                                               HandOfFiveCards blackHand, HandOfFiveCards whiteHand) {
        if(onePairTieBreakerArrayListForBlack.get(0) > onePairTieBreakerArrayListForWhite.get(0)){
            return true;
        } else if(onePairTieBreakerArrayListForBlack.get(0) < onePairTieBreakerArrayListForWhite.get(0)){
            return false;
        } else{
            for(int i = blackHand.getSortedHand().size()-1; i >= 0 ;i--){
                if(compareBothHandsAtSamePosition(blackHand, i, whiteHand)){
                } else{
                    return compareSameHandPositionForBlackWin(blackHand, i, whiteHand);
                }
            }
            return FlipCoin();
        }
    }

    public boolean TwoPairTieBreakerComparison(ArrayList<Integer> twoPairTieBreakerArrayListForBlack, 
                                               ArrayList<Integer> twoPairTieBreakerArrayListForWhite, 
                                               HandOfFiveCards blackHand, HandOfFiveCards whiteHand) {
        if(twoPairTieBreakerArrayListForBlack.get(1)>twoPairTieBreakerArrayListForWhite.get(1)){
            return true;
        } else if(twoPairTieBreakerArrayListForBlack.get(1)<twoPairTieBreakerArrayListForWhite.get(1)){
            return false;
        }
        
        if(twoPairTieBreakerArrayListForBlack.get(0)>twoPairTieBreakerArrayListForWhite.get(0)){
            return true;
        } else if(twoPairTieBreakerArrayListForBlack.get(0)<twoPairTieBreakerArrayListForWhite.get(0)){
            return false;
        }
        
        if(compareSameHandPositionForBlackWin(blackHand, 0, whiteHand)){
            return true;
        } else if(blackHand.getSortedHand().get(0)<whiteHand.getSortedHand().get(0)){
            return false;
        } return FlipCoin();
    }

    public int deleteMatchingPairFromArray(HandOfFiveCards whiteHand, int i) {
        whiteHand.getSortedHand().remove(i);
        whiteHand.getSortedHand().remove(i);
        i--;
        return i;
    }
    
    public boolean FlipCoin() {
        int randomNum = ThreadLocalRandom.current().nextInt(0,2);
        System.out.println("A Tie Break Could Not Be Established. A Coin Flip Will Decide"
                + " The Winner! (otherwise split the pot accordingly):");
        return randomNum == 0;
    }
}
