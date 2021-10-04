package nl.hu.bep2.casino.blackjack.presentation;

import javax.validation.constraints.Positive;

public class Bet {
    @Positive
    private final Integer bet;

    public Bet(@Positive Integer bet) {
        this.bet = bet;
    }

    public Integer getBet() {
        return bet;
    }
}
