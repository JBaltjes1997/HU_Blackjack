package nl.hu.bep2.casino.blackjack.presentation.Dto;

import nl.hu.bep2.casino.blackjack.domain.Hand;

public class GameDto {
    public Long id;
    public Long bet;
    public Hand playerHand;
    public Hand dealerHand;
}

