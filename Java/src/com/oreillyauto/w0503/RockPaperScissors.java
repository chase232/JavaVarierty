package com.oreillyauto.w0503;

public enum RockPaperScissors {
    
    ROCK(1),
    PAPER(2),
    SCISSORS(3);
    
    private final int number;
    
    public int getNumber() {
        return number;
    }

    RockPaperScissors(int number) {
        this.number = number;
    }
}
