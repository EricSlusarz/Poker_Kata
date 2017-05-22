package pokerkata;

import java.util.ArrayList;
import java.util.Collections;

public class HandOfFiveCards {
  
    private String firstCardsuit;
    private String secondCardsuit;
    private String thirdCardsuit;
    private String fourthCardsuit;
    private String fifthCardsuit;

    private String firstCardValue;
    private String secondCardValue;
    private String thirdCardValue;
    private String fourthCardValue;
    private String fifthCardValue;
    
    private ArrayList<String> listOfValues;
    private ArrayList<Integer> sortedListOfNumericValues;
    
    private int numericValueToAdd;
    
    private static int instanceCounter = 0;
    int counter = 0;
    
    private String player = "White Player";
    
  public HandOfFiveCards(){
        listOfValues = new ArrayList<>();
        sortedListOfNumericValues = new ArrayList<>();
  }
  
    public void makeANewHand(String firstCard, String secondCard,String thirdCard, 
                             String fourthCard,String fifthCard){
      sortHandConsecutively(firstCard, secondCard, thirdCard, fourthCard, fifthCard);
      instanceCounter++;
      counter = instanceCounter;
      if(counter%2==0){
          player = "Black Player";
      }  
    }  

    private void sortHandConsecutively(String firstCard, String secondCard, String thirdCard, 
                          String fourthCard,String fifthCard) {

        listOfValues.removeAll(listOfValues);
        sortedListOfNumericValues.removeAll(sortedListOfNumericValues);
        
        firstCardsuit = firstCard.substring(1);
        firstCardValue = firstCard.substring(0,1);
        
        secondCardsuit = secondCard.substring(1);
        secondCardValue = secondCard.substring(0,1);

        thirdCardsuit = thirdCard.substring(1);
        thirdCardValue = thirdCard.substring(0,1);
        
        fourthCardsuit = fourthCard.substring(1);
        fourthCardValue = fourthCard.substring(0,1);
        
        fifthCardsuit = fifthCard.substring(1);
        fifthCardValue = fifthCard.substring(0,1);
           
        listOfValues.add(firstCardValue);
        listOfValues.add(secondCardValue);
        listOfValues.add(thirdCardValue);
        listOfValues.add(fourthCardValue);
        listOfValues.add(fifthCardValue);
        
        for(int i=0; i < listOfValues.size(); i++){
            if(listOfValues.get(i).equals("T")){
                listOfValues.set(i, "10");
            }
            if(listOfValues.get(i).equals("J")){
                listOfValues.set(i, "11");
            }
            if(listOfValues.get(i).equals("Q")){
                listOfValues.set(i, "12");
            }            
            if(listOfValues.get(i).equals("K")){
                listOfValues.set(i, "13");
            }
            if(listOfValues.get(i).equals("A")){
                listOfValues.set(i, "14");
            }
        sortedListOfNumericValues.add(numericValueToAdd  = Integer.parseInt(listOfValues.get(i)));
        }
        
        Collections.sort(sortedListOfNumericValues);
    }

    public String getFirstCardsuit() {
        return firstCardsuit;
    }

    public String getSecondCardsuit() {
        return secondCardsuit;
    }

    public String getThirdCardsuit() {
        return thirdCardsuit;
    }

    public String getFourthCardsuit() {
        return fourthCardsuit;
    }

    public String getFifthCardsuit() {
        return fifthCardsuit;
    }
    
    public int getCounter() {
        return counter;
    }
    
    public String getPlayer() {
        return player;
    }
    
    public void printOutHand(){
        System.out.println(firstCardValue+firstCardsuit  +" "+
                           secondCardValue+secondCardsuit+" "+
                           thirdCardValue+thirdCardsuit  +" "+
                           fourthCardValue+fourthCardsuit+" "+
                           fifthCardValue+fifthCardsuit); 
    }
    
    public ArrayList<Integer> getSortedHand() {
        return sortedListOfNumericValues;
    }
}