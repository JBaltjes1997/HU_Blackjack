package nl.hu.bep2.casino.blackjack.domain;

import nl.hu.bep2.casino.blackjack.domain.Cards.Card;
import nl.hu.bep2.casino.blackjack.domain.Cards.Rank;
import nl.hu.bep2.casino.blackjack.domain.Cards.Suit;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck implements Serializable {

    private Long Id;
    private List<Card> cards = new ArrayList<Card>();

    public Deck(Long id, List<Card> cards) {
        Id = id;
        this.cards = cards;
    }

    public Deck(ArrayList<Card> cards){
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                this.cards.add(new Card(rank, suit));
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card drawCard() {
        return this.cards.remove(0);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public static Deck full() {
        ArrayList<Card> cards = new ArrayList<>();

        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(rank, suit));
            }

        }
        Deck deck = new Deck(cards);
        deck.shuffle();
        return deck;
    }
}





