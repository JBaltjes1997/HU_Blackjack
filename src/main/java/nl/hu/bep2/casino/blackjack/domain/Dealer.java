package nl.hu.bep2.casino.blackjack.domain;


import nl.hu.bep2.casino.blackjack.domain.Cards.Card;

public class Dealer {
    private Deck deck;
    private Hand hand;

    public Dealer(Deck deck, Hand hand) {
        this.deck = deck;
        this.hand = hand;
    }

    public Hand getHand() {
        return hand;
    }

    public Dealer(){}

    public Card dealCard(){
        Card kaart = deck.getCards().get(0);
        deck.getCards().remove(kaart);
        return kaart;
    }

    public void dealCardToSelve(){
        this.hand.addCard(dealCard());
    }




}
