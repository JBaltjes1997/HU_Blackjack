package nl.hu.bep2.casino.blackjack.domain;

import nl.hu.bep2.casino.blackjack.domain.Cards.Card;
import nl.hu.bep2.casino.blackjack.domain.Cards.Rank;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue
    private Long id;

    private Long bet;

    @Lob
    private Hand playerHand;

    @Lob
    private Hand dealerHand;

    private String userName;

    @Lob
    private Deck deck;

    // dealCards zou als laatste in de constructor aangeroepen moeten worden

    public Game(){}

    public Game(String username, Long bet) {
        this.userName = username;
        this.bet = bet;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBet(Long bet) {
        this.bet = bet;
    }

    public Long getId() {
        return id;
    }

    public Long getBet() {
        return bet;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public Hand getDealerHand() {
        return dealerHand;
    }

    public String getUserName() {
        return userName;
    }

    public void playerHit(){
        playerHand.addCard(deck.drawCard());
    }
    public void dealerHit(){ dealerHand.addCard(deck.drawCard()); }

    //    public void dealOneCardToPlayer(){
//        player.getHand().addCard(dealer.dealCard());
//    }
//
//    public void dealOneCardToDealer(){
//        dealer.getHand().addCard(dealer.dealCard());
//    }

//    public void dealCards(){
//        player.getHand().addCard(dealer.dealCard());
//        dealer.dealCardToSelve();
//        player.getHand().addCard(dealer.dealCard());
//    }

    public void startGame(String userName, Long bet){
        this.userName = userName;
        this.bet = bet;
        this.playerHand = new Hand();
        this.dealerHand = new Hand();
        this.deck = Deck.full();
        this.deck.shuffle();

        this.playerHand.addCard(deck.drawCard());
        this.playerHand.addCard(deck.drawCard());
        this.dealerHand.addCard(deck.drawCard());

    }
//
//    public void hit(){ dealOneCardToPlayer(); }

    public boolean checkBust(){
        List<Card> cards = playerHand.getCards();
        int value = 0;
        for(Card c : cards){
            value += c.getRank().getRank();
        }
        if(value > 21){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkBlackJack(){
       List<Card> cards = playerHand.getCards();
       int value = 0;
       for(Card c : cards){
           value += c.getRank().getRank();
       }
       if(value == 21){
           return true;
       } else {
           return false;
       }
    }

    public void checkAceValue(){
        List<Card> cards = playerHand.getCards();
        for(Card c : cards){
            if(c.getRank() == Rank.ACE){
               c.getRank().setRank(1);
               return;
            }
        }
    }


}
