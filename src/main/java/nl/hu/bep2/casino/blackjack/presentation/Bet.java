package nl.hu.bep2.casino.blackjack.presentation;

import javax.validation.constraints.Positive;

public class Bet {
    @Positive
    private final Long bet;

    public Bet(@Positive Long bet) {
        this.bet = bet;
    }

    public Long getBet() {
        return bet;
    }
}
