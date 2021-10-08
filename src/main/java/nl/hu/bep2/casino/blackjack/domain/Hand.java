package nl.hu.bep2.casino.blackjack.domain;

import nl.hu.bep2.casino.blackjack.domain.Cards.Card;

import java.util.ArrayList;
import java.util.List;


public class Hand {
    private List<Card> cards = new ArrayList<Card>();

    public Hand(){}

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

}
