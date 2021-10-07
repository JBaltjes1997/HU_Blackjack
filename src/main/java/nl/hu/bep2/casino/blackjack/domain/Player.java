package nl.hu.bep2.casino.blackjack.domain;

public class Player {
    private String username;
    private long bet;
    private Hand hand;

    public Player(String username, long bet, Hand hand) {
        this.username = username;
        this.bet = bet;
        this.hand = hand;
    }

    public Hand getHand() {
        return hand;
    }

    public Player(){}

    public String getUsername(){
        return username;
    }
}
