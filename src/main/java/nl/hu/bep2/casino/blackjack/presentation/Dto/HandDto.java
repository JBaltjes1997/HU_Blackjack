package nl.hu.bep2.casino.blackjack.presentation.Dto;

import java.util.List;

public class HandDto {
    List<CardDto> cards;

    public HandDto(List<CardDto> cards) {
        this.cards = cards;
    }

    public List<CardDto> getCards() {
        return cards;
    }

    public void setCards(List<CardDto> cards) {
        this.cards = cards;
    }
}
