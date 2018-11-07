package com.oreillyauto.w0602;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    
    private ArrayList<Card> deck = new ArrayList<>();
    private int cardsDealt;
    
    public Deck() {
        deck = new ArrayList<>();
        for (int suit = 0; suit < 3; suit++) {
            for (int value = 1; value < 13; value++) {
                deck.add(new Card(suit, value));
            }
        }
    }
    
   public void shuffleDeck() {
       Collections.shuffle(deck);
   }
   
   public Card dealCard() {
       if (cardsDealt == 52) {
           Collections.shuffle(deck);
       }
       cardsDealt++;
       return deck.get(cardsDealt);
   }
}
