package nl.hu.bep2.casino.blackjack.domain;

public class Move {
    private boolean hit;
    private boolean stay;

    public Move(boolean hit, boolean stay) {
        this.hit = hit;
        this.stay = stay;
    }

    public boolean isHit() {
        return hit;
    }

    public boolean isStay() {
        return stay;
    }
}
