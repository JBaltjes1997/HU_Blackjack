package nl.hu.bep2.casino.blackjack.presentation.Dto;

public class CardDto {
    String suit;
    String rank;

    public CardDto(String suit, String rank){
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
