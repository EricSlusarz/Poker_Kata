package pokerkata;

public class HandRankings {

    private int scoreOfHand;
    private String NameOfHand;
    public boolean findHandRanking;

    public void evaluatePokerHand(HandOfFiveCards hand) {
            findHandRanking = true;
                                      evaluateHandForStraightFlush(hand);
            if (this.findHandRanking) evaluateHandForFourOfAKind(hand);
            if (this.findHandRanking) evaluateHandForFullHouse(hand);
            if (this.findHandRanking) evaluateHandForFlush(hand);
            if (this.findHandRanking) evaluateHandForStraight(hand);
            if (this.findHandRanking) evaluateHandForThreeOfAKind(hand);
            if (this.findHandRanking) evaluateHandForTwoPairs(hand);     
            if (this.findHandRanking) evaluateForOnePair(hand);                        
            if(this.findHandRanking){
                scoreOfHand = 1;
                NameOfHand = "High Card";            
                this.findHandRanking = false;
            } //Automatically evaluate for High Card
    }

    public void evaluateForOnePair(HandOfFiveCards hand) {

        if (compareTwoPositionsInHand(hand, 0, 1) || compareTwoPositionsInHand(hand, 1, 2)
         || compareTwoPositionsInHand(hand, 2, 3) || compareTwoPositionsInHand(hand, 3, 4)){
            NameOfHand = "One Pair";
            scoreOfHand = 2;
            this.findHandRanking = false;
        }
    }

    public void evaluateHandForTwoPairs(HandOfFiveCards hand) {
        if (compareTwoPositionsInHand(hand, 0, 1) && compareTwoPositionsInHand(hand, 2, 3)
         || compareTwoPositionsInHand(hand, 0, 1) && compareTwoPositionsInHand(hand, 3, 4)
         || compareTwoPositionsInHand(hand, 1, 2) && compareTwoPositionsInHand(hand, 3, 4)){
            NameOfHand = "Two Pair";
            scoreOfHand = 3;
            this.findHandRanking = false;
        }
    }

    public void evaluateHandForThreeOfAKind(HandOfFiveCards hand) {
        if (compareTwoPositionsInHand(hand, 0, 2)
         || compareTwoPositionsInHand(hand, 1, 3)
         || compareTwoPositionsInHand(hand, 2, 4)) {
            NameOfHand = "Three of a kind";
            scoreOfHand = 4;
            this.findHandRanking = false;
        }
    }

    public void evaluateHandForStraight(HandOfFiveCards hand) {
        boolean isAStraight = true;
        for (int i = 0; i < hand.getSortedHand().size() - 1; i++) {
            if (findConsecutiveValues(hand, i)) {
                isAStraight = false;
                break;
            }
        }
        if (isAStraight) {
            NameOfHand = "Straight";
            scoreOfHand = 5;
            this.findHandRanking = false;
        }
    }

    public void evaluateHandForFlush(HandOfFiveCards hand) {
        if (compareAllCardsForSameSuit(hand)) {
            NameOfHand = "Flush";
            scoreOfHand = 6;
            this.findHandRanking = false;
        }
    }

    public void evaluateHandForFullHouse(HandOfFiveCards hand) {
        if (compareTwoPositionsInHand(hand, 0, 2) && compareTwoPositionsInHand(hand, 3, 4)
        ||  compareTwoPositionsInHand(hand, 0, 1) && compareTwoPositionsInHand(hand, 2, 4)) {
            NameOfHand = "Full House";
            scoreOfHand = 7;
            this.findHandRanking = false;
        }
    }

    public void evaluateHandForFourOfAKind(HandOfFiveCards hand) {
        if (compareTwoPositionsInHand(hand, 0, 3)
         || compareTwoPositionsInHand(hand, 1, 4)) {
            NameOfHand = "Four of A Kind";
            scoreOfHand = 8;
            this.findHandRanking = false;
        }
    }

    public void evaluateHandForStraightFlush(HandOfFiveCards hand) {
        boolean isAStraightFlush = false;
        if (compareAllCardsForSameSuit(hand)) {
            for (int i = 0; i < hand.getSortedHand().size() - 1; i++) {
                if (findConsecutiveValues(hand, i)) {
                    isAStraightFlush = false;
                    break;
                } else {
                    isAStraightFlush = true;
                }
            }
            if (isAStraightFlush) {
                NameOfHand = "Straight Flush";
                scoreOfHand = 9;
                this.findHandRanking = false;
            }
        }
    }

    public boolean findConsecutiveValues(HandOfFiveCards hand, int i) {
        return hand.getSortedHand().get(i) + 1 != hand.getSortedHand().get(i + 1);
    }

    public boolean compareAllCardsForSameSuit(HandOfFiveCards hand){
        return     hand.getFifthCardsuit().equals(hand.getFourthCardsuit())
                && hand.getFourthCardsuit().equals(hand.getThirdCardsuit())
                && hand.getThirdCardsuit().equals(hand.getSecondCardsuit())
                && hand.getSecondCardsuit().equals(hand.getFirstCardsuit());
    }

    public boolean compareTwoPositionsInHand(HandOfFiveCards hand, int firstPosition, int SecondPosition) {
        return hand.getSortedHand().get(firstPosition).equals(hand.getSortedHand().get(SecondPosition));
    }

    public void setScoreOfHand(int scoreOfHand) {
        this.scoreOfHand = scoreOfHand;
    }
    
    public int getScoreOfHand() {
        return scoreOfHand;
    }

    public String getNameOfHand() {
        return NameOfHand;
    }
}