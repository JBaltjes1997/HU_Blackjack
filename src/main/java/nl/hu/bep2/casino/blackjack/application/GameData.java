package nl.hu.bep2.casino.blackjack.application;

import nl.hu.bep2.casino.blackjack.domain.Cards.Card;
import nl.hu.bep2.casino.blackjack.domain.Cards.Rank;
import nl.hu.bep2.casino.blackjack.domain.Hand;

import javax.persistence.*;
import java.util.List;

public class GameData {

    private Long id;

    private Long bet;

    private Hand playerHand;

    private Hand dealerHand;

    private String userName;

    public GameData(Long id, Long bet, Hand playerHand, Hand dealerHand, String userName) {
        this.id = id;
        this.bet = bet;
        this.playerHand = playerHand;
        this.dealerHand = dealerHand;
        this.userName = userName;
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


    //    public boolean checkBlackJack(){
//        List<Card> cards = player.getHand().getCards();
//        int value = 0;
//        for(Card c : cards){
//            value += c.getRank().getRank();
//        }
//        if(value == 21){
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public void checkAceValue(){
//        List<Card> cards = player.getHand().getCards();
//        for(Card c : cards){
//            if(c.getRank() == Rank.ACE){
//                c.getRank().setRank(1);
//                return;
//            }
//        }
//    }


}
