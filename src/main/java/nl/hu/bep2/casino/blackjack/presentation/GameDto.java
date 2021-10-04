package nl.hu.bep2.casino.blackjack.presentation;

import javax.validation.constraints.Positive;

public class GameDto {
    Long id;
    Long bet;
    HandDto PlayerHand;
    HandDto dealerHand;
}

