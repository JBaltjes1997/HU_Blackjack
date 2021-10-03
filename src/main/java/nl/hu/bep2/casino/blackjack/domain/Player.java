package nl.hu.bep2.casino.blackjack.domain;

public class Player {
    private String username;
    private long bet;

    public Player(String username, long bet){
        this.username = username;
        this.bet = bet;
    }

    public String getUsername(){
        return username;
    }
}
