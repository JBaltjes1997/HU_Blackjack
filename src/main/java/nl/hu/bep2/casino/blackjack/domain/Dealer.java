//package nl.hu.bep2.casino.blackjack.domain;
//
//import java.util.Random;
//
//
//import nl.hu.bep2.casino.blackjack.domain.Cards.Card;
//
//import javax.persistence.*;
//
//@Entity
//public class Dealer {
//    @Id
//    @GeneratedValue
//    private Long id;
//    @OneToOne(cascade = {CascadeType.ALL})
//    private Deck deck = new Deck();
//    @OneToOne(cascade = {CascadeType.ALL})
//    private Hand hand = new Hand();
//    @OneToOne
//    @JoinColumn(name = "id")
//    private Game game;
//
//
//    public Dealer(Long id, Deck deck, Hand hand) {
//        this.id = id;
//        this.deck = deck;
//        this.hand = hand;
//    }
//
//    public Hand getHand() {
//        return hand;
//    }
//
//    public Dealer(){}
//
//    public Card dealCard(){
//        Random rand = new Random();
//        Card kaart = deck.getCards().get(rand.nextInt(53));
//        deck.getCards().remove(kaart);
//        return kaart;
//    }
//
//    public void dealCardToSelve(){
//        this.hand.addCard(dealCard());
//    }
//
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
//}
