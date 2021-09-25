package nl.hu.bep2.casino.blackjack.domain;

public class Deck {
    private int aantalKaarten;

    public Deck(int aantalKaarten){
        this.aantalKaarten = aantalKaarten;
    }

    public void setAantalKaarten(int aantalKaarten) {
        this.aantalKaarten = aantalKaarten;
    }
}
