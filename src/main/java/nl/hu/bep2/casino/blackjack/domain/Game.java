package nl.hu.bep2.casino.blackjack.domain;

public class Game {
    private Deck deck = new Deck();
    private Player player;

    public Game(String username, Long bet){
        player = new Player(username, bet);
    }

    public Long getId(){return 12L;}

    public String getPlayerName(){return player.getUsername();}

    public Long getBet(){return null;}

}
