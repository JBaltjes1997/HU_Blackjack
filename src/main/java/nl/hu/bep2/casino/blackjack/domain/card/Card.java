package nl.hu.bep2.casino.blackjack.domain.card;

public class Card {
    private int rank;
    private String suit;

    public Card(int rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank(){
        return rank;
    }

    public String getSuit(){
        return suit;
    }
}
