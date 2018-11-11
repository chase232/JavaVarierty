package com.oreillyauto.w0602;

import java.util.ArrayList;

public class Hand {

    ArrayList<Card> hand = new ArrayList<>();
    
    public Hand() {
        hand = new ArrayList<>();
    }
    
    public void addCard(Card card) {
        hand.add(card);
    }
    
    public Card getCard(int index) {
        return hand.get(index);
    }
    
    public int cardCount() {
        return hand.size();
    }
    
    public int getHandValue() {
        
        int handValue = 0;
        int cards = hand.size();
        boolean ace = false;
        
        for (int i = 0; i < cards; i++) {
            
            Card card;
            card = getCard(i);
            int cardValue;
            cardValue = card.getValue();
            if (cardValue > 10) {
                cardValue = 10;
            } 
            
            if (cardValue == 1) {
                ace = true;
            }
            
            handValue += cardValue;
        }
        
        if (ace == true  &&  (handValue + 10) <= 21) {
            handValue = handValue + 10;
        } 
        
        return handValue;
    }
}











