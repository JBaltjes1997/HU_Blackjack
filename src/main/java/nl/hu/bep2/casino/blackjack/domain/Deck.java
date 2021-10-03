package nl.hu.bep2.casino.blackjack.domain;

import nl.hu.bep2.casino.blackjack.domain.Cards.Card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Deck implements Serializable {
    private List<Card> cards = new ArrayList<>();

    public Deck(List<Card> cards){
        this.cards = cards;
    }

    public Deck() {

    }
}
