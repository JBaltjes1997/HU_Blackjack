package nl.hu.bep2.casino.blackjack.domain;

import nl.hu.bep2.casino.blackjack.domain.Cards.Card;
import nl.hu.bep2.casino.blackjack.presentation.Bet;

public class Game {
    private Player player;
    private Dealer dealer;
    private Bet bet;

    public Game(Player player, Dealer dealer, Bet bet) {
        this.player = player;
        this.dealer = dealer;
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

    public String getPlayerName(){return player.getUsername();}

    public Bet getBet(){return this.bet;}

    public void dealCards(){
        player.getHand().addCard(dealer.dealCard());
        dealer.dealCardToSelve();
        player.getHand().addCard(dealer.dealCard());
        dealer.dealCardToSelve();
    }



}
