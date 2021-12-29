package nl.hu.bep2.casino.blackjack.domain;

import nl.hu.bep2.casino.blackjack.domain.Cards.Card;
import nl.hu.bep2.casino.blackjack.domain.Cards.Rank;
import nl.hu.bep2.casino.blackjack.domain.Cards.Suit;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Hand implements Serializable {

//    private Long id;

    private List<Card> cards = new ArrayList<Card>();

//    public Hand(Long id, List<Card> cards) {
//        this.id = id;
//        this.cards = cards;
//    }

    public Hand(List<Card> cards) {
//        this.id = id;
        this.cards = cards;
    }

    public Hand(){}

//    public List<Card> getCards() {
//        return cards;
//    }

    public List<Card> getCards() {
//        for(Card card : cards){
//            System.out.println(card.getRank());
//            System.out.println(card.getSuit());
//        }
        return this.cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }


}
