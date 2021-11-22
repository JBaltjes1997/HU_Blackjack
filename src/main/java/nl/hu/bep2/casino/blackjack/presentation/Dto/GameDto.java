package nl.hu.bep2.casino.blackjack.presentation.Dto;

import nl.hu.bep2.casino.blackjack.domain.Cards.Card;
import nl.hu.bep2.casino.blackjack.domain.Hand;

import java.util.List;

public class GameDto {
    public Long id;
    public Long bet;
    public List<Card> playerHand;
    public List<Card> dealerHand;

    public GameDto(Long id, Long bet, List<Card> playerHand, List<Card> dealerHand) {
        this.id = id;
        this.bet = bet;
        this.playerHand = playerHand;
        this.dealerHand = dealerHand;
    }

    public GameDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBet() {
        return bet;
    }

    public void setBet(Long bet) {
        this.bet = bet;
    }

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public List<Card> getDealerHand() {
        return dealerHand;
    }

}

