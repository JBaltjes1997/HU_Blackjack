package nl.hu.bep2.casino.blackjack.presentation.Dto;

import javax.validation.constraints.Positive;

public class BetDto {
    @Positive
    public Long value;
}
