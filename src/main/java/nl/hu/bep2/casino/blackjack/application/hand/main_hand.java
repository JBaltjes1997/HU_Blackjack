package nl.hu.bep2.casino.blackjack.application.hand;

import nl.hu.bep2.casino.blackjack.application.cards.main_card;

import java.util.ArrayList;
import java.util.List;

public class main_hand {
    private ArrayList<main_card> hand;

    public int getHandValue(){
        int value = 0;
        for(int i = 0; i < hand.size(); i++ ){
            value = value + hand[i];
        }
        return value;
    }

    public void addCard(main_card card){
        hand.add(card);
    }

    public void showHand(){
        for(main_card card : hand){
            System.out.println(card);
        }
    }
}
