package nl.hu.bep2.casino.blackjack.domain;

import nl.hu.bep2.casino.blackjack.domain.Cards.Card;
import nl.hu.bep2.casino.blackjack.presentation.Bet;

public class Game {
    private Player player = new Player();
    private Dealer dealer = new Dealer();
    private Long bet;
    private String playerName;

    public Game(String playerName, Long bet) {
        this.playerName = playerName;
        this.bet = bet;
    }

    public Game(){}

    public Long getId(){return 12L;}

    public Player getPlayer() {
        return player;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setBet(Long bet) {
        this.bet = bet;
    }

    public Long getBet(){return this.bet;}

    public void dealCards(){
        player.getHand().addCard(dealer.dealCard());
        dealer.dealCardToSelve();
        player.getHand().addCard(dealer.dealCard());
        dealer.dealCardToSelve();
    }



}
