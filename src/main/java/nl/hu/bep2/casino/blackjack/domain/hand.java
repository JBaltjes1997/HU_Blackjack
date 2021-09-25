package nl.hu.bep2.casino.blackjack.domain;

public class hand {
    private int aantalKaarten;
    private int waarde;

    public hand(int aantalKaarten, int waarde){
        this.aantalKaarten = aantalKaarten;
        this.waarde = waarde;
    }

    public int getAantalKaarten() {
        return aantalKaarten;
    }

    public void setAantalKaarten(int aantalKaarten) {
        this.aantalKaarten = aantalKaarten;
    }

    public int getWaarde() {
        return waarde;
    }

    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }
}
