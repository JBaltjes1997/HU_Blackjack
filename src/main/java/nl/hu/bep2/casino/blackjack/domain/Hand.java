package nl.hu.bep2.casino.blackjack.domain;

import nl.hu.bep2.casino.blackjack.domain.cards.Card;
import nl.hu.bep2.casino.blackjack.domain.cards.Rank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Hand implements Serializable {

    private List<Card> cards = new ArrayList<Card>();

    public Hand(List<Card> cards) {
        this.cards = cards;
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

    public int handValue(){
        int value = 0;
        for(Card c : cards){
            value += c.getRank().getRank();
        }
        checkAceValue();
        return value;
    }

    public void checkAceValue(){
        for(Card c : cards){
            if(c.getRank() == Rank.ACE){
                c.getRank().setRank(1);
                return;
            }
        }
    }



}
