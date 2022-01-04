package nl.hu.bep2.casino.blackjack.domain;

import nl.hu.bep2.casino.blackjack.domain.Cards.Card;
import nl.hu.bep2.casino.blackjack.domain.Cards.Rank;
import nl.hu.bep2.casino.blackjack.domain.Cards.Suit;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Hand implements Serializable {

    private List<Card> cards = new ArrayList<Card>();
    private int handValue;

    public Hand(List<Card> cards, int handValue) {
        this.cards = cards;
        this.handValue = handValue;
    }

    public Hand(){}

    public List<Card> getCards() {
        return this.cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public void setHandValue(int handValue) {
        this.handValue = handValue;
    }

    public int getHandValue(Hand hand) {
        return handValue;
    }
}
