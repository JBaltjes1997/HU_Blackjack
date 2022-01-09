package nl.hu.bep2.casino.blackjack.domain;

import nl.hu.bep2.casino.blackjack.domain.exceptions.NotAllowedException;

import javax.persistence.*;

import static nl.hu.bep2.casino.blackjack.domain.GameStates.*;

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

    private GameStates state;

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

    public GameStates getState() {
        return state;
    }

    public void playerHit(){
        playerHand.addCard(deck.drawCard());
    }
    public void dealerHit(){ dealerHand.addCard(deck.drawCard()); }

    public void startGame(String userName, Long bet){
        this.userName = userName;
        this.bet = bet;
        this.playerHand = new Hand();
        this.dealerHand = new Hand();
        this.deck = Deck.full();
        this.deck.shuffle();
        this.state = on_going;

        this.playerHand.addCard(deck.drawCard());
        this.playerHand.addCard(deck.drawCard());
        this.dealerHand.addCard(deck.drawCard());

        if(playerHand.handValue() == 21 ){
            state = GameStates.blackjack;
        }
    }

    public void hit() {
        if (!state.equals(on_going)) {
            throw new NotAllowedException("Kan niet want het spel is al afgelopen / nog niet begonnen ");
        }

        this.playerHand.addCard(deck.drawCard());

        if (playerHand.handValue() > 21) {
            state = GameStates.bust;
        }
    }

    public void stand(){
        if (!state.equals(on_going)) {
            throw new NotAllowedException("Kan niet want het spel is al afgelopen / nog niet begonnen ");
        }

        this.dealerHand.addCard(deck.drawCard());
        while(dealerHand.handValue() < 17){
            this.dealerHand.addCard(deck.drawCard());
        }
        dealerHand.checkAceValue();

        if(dealerHand.handValue() > 21){
            state = GameStates.won;

        } else {
            if (playerHand.handValue() > dealerHand.handValue()) {
                state = GameStates.won;

            } else if (playerHand.handValue() < dealerHand.handValue()){
                state = GameStates.lost;

            } else if (playerHand.handValue() == dealerHand.handValue()){
                state = GameStates.push;
            }
        }
    }

    public void doubleDown(){
        if (!state.equals(on_going)) {
            throw new NotAllowedException("DoubleDown mag alleen bij de eerste 2 kaarten");
        }

        bet *= 2;

        this.hit();
        playerHand.checkAceValue();

        if(playerHand.handValue() > 21){
            state = GameStates.bust;
        }

    }

    public void surrender(){
        if (!state.equals(on_going)) {
            throw new NotAllowedException("Kan niet want het spel is al afgelopen / nog niet begonnen ");
        }
        state = GameStates.resigned;
    }
}
