package com.oreillyauto.w0602;

public class Card {
    
    // Declaring data members
    public final static int HEARTS = 0;
    public final static int DIAMONDS = 1;
    public final static int CLUBS = 2;
    public final static int SPADES = 3;
    
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;
    public final static int ACE = 1;
    
    private int suit;
    private int value;
    
    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
    }
    
    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }    

    // Used to return card value
    public int checkCurrentHand(int i) {
        switch (i) {
            case 1:
            case 14:
            case 27:
            case 40:
                return 11;
            case 2:
            case 15:
            case 28:
            case 41:
                return 2;
            case 3:
            case 16:
            case 29:
            case 42:
                return 3;
            case 4:
            case 17:
            case 30:
            case 43:
                return 4;
            case 5:
            case 18:
            case 31:
            case 44:
                return 5;
            case 6:
            case 19:
            case 32:
            case 45:
                return 6;
            case 7:
            case 20:
            case 33:
            case 46:
                return 7;
            case 8:
            case 21:
            case 34:
            case 47:
                return 8;
            case 9:
            case 22:
            case 35:
            case 48:
                return 9;
            case 10:
            case 23:
            case 36:
            case 49:
                return 10;
            case 11:
            case 24:
            case 37:
            case 50:
                return 10;
            case 12:
            case 25:
            case 38:
            case 51:
                return 10;
            case 13:
            case 26:
            case 39:
            case 52:
                return 10;
            default:
                break;
        }
        return 0;
    }
}
