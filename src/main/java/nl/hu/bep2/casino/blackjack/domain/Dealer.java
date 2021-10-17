package nl.hu.bep2.casino.blackjack.domain;

import java.util.Random;


import nl.hu.bep2.casino.blackjack.domain.Cards.Card;

public class Dealer {
    private Deck deck = new Deck();
    private Hand hand = new Hand();

    public Hand getHand() {
        return hand;
    }

    public Dealer(){}

    public Card dealCard(){
        Random rand = new Random();
        Card kaart = deck.getCards().get(rand.nextInt(53));
        deck.getCards().remove(kaart);
        return kaart;
    }

    public void dealCardToSelve(){
        this.hand.addCard(dealCard());
    }




}
