package nl.hu.bep2.casino.blackjack.application;

import nl.hu.bep2.casino.blackjack.domain.GameStates;
import nl.hu.bep2.casino.blackjack.domain.Hand;

public class GameData {

    private final Long id;

    private final Long bet;

    private final Hand playerHand;

    private final Hand dealerHand;

    private final String userName;

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
