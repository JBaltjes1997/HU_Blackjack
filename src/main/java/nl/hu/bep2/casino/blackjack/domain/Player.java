package nl.hu.bep2.casino.blackjack.domain;

public class Player {
    private Hand hand = new Hand();

    public Hand getHand() {
        return hand;
    }

    public Player(){}
}
