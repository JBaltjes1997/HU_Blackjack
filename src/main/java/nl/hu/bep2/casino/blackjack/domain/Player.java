//package nl.hu.bep2.casino.blackjack.domain;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//public class Player implements Serializable {
//    @Id
//    @GeneratedValue
//    private Long id;
//    @OneToOne(cascade = {CascadeType.ALL})
//    private Hand hand = new Hand();
//    @OneToOne(cascade = {CascadeType.ALL})
//
//    public Player(Long id, Hand hand) {
//        this.id = id;
//        this.hand = hand;
//    }
//
//    public Player(){}
//
//    public Hand getHand() {
//        return hand;
//    }
//
//}
