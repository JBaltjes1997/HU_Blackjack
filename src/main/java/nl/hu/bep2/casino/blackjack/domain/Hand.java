package nl.hu.bep2.casino.blackjack.domain;

public class Hand {
    private int value;

    public Hand(int waarde){
        this.value = waarde;
    }

    public int getValue() {
        return value;
    }
}
