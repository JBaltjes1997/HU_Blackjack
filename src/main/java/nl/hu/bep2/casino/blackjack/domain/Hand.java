package nl.hu.bep2.casino.blackjack.domain;

import nl.hu.bep2.casino.blackjack.domain.Cards.Card;

import java.util.List;

public class Hand {
    private int value;
    private List<Card> cards;

    public Hand(int value, List<Card> cards) {
        this.value = value;
        this.cards = cards;
    }

    public Hand(){}

    public int getValue() {
        return value;
    }

    public void addCard(Card card){
        this.cards.add(card);
    }




}
