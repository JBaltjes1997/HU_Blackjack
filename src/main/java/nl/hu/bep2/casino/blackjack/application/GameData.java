package nl.hu.bep2.casino.blackjack.application;

import nl.hu.bep2.casino.blackjack.domain.Cards.Card;
import nl.hu.bep2.casino.blackjack.domain.Cards.Rank;
import nl.hu.bep2.casino.blackjack.domain.Hand;

import javax.persistence.*;
import java.util.List;

public class GameData {

    private Long id;

    private Long bet;

    private Hand playerHand;

    private Hand dealerHand;

    private String userName;

    private GameStates state;

    public GameData(Long id, Long bet, Hand playerHand, Hand dealerHand, String userName, GameStates state) {
        this.id = id;
        this.bet = bet;
        this.playerHand = playerHand;
        this.dealerHand = dealerHand;
        this.userName = userName;
        this.state = state;

    }

    public Long getId() {
        return id;
    }

    public Long getBet() {
        return bet;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public Hand getDealerHand() {
        return dealerHand;
    }

    public String getUserName() {
        return userName;
    }

    public GameStates getState() {
        return state;
    }

    public void setState(GameStates state) {
        this.state = state;
    }
}
