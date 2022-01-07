package nl.hu.bep2.casino.blackjack.domain;

import nl.hu.bep2.casino.blackjack.application.GameData;
import nl.hu.bep2.casino.blackjack.application.GameStates;
import nl.hu.bep2.casino.blackjack.domain.cards.Card;
import nl.hu.bep2.casino.blackjack.domain.exceptions.NotAllowedException;

import javax.persistence.*;
import java.util.List;

import static nl.hu.bep2.casino.blackjack.application.GameStates.*;

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
        this.state = GameStates.on_going;

        this.playerHand.addCard(deck.drawCard());
        this.playerHand.addCard(deck.drawCard());
        this.dealerHand.addCard(deck.drawCard());

        if(playerHand.handValue() == 21 ){
//            chipsService.depositChips(username, (long) (bet*1.5));
            state = GameStates.blackjack;
        }
    }

//    public static int getHandValue(Hand hand){
//        List<Card> cards = hand.getCards();
//        int value = 0;
//        for(Card c : cards){
//            value += c.getRank().getRank();
//        }
//        return value;
//    }

    public void hit() {
        if (!state.equals(on_going)) {
            throw new NotAllowedException();
        }

        this.playerHand.addCard(deck.drawCard());

        if (playerHand.handValue() > 21) {
            state = GameStates.bust;
        }
    }

    public void stand(){
        if (!state.equals(on_going)) {
            throw new NotAllowedException();
        }

        this.dealerHand.addCard(deck.drawCard());
        while(dealerHand.handValue() < 17){
            this.dealerHand.addCard(deck.drawCard());
        }
        dealerHand.checkAceValue();

//        GameData gameData = new GameData(game.getId(), game.getBet(), game.getPlayerHand(),
//                game.getDealerHand(), game.getUserName(), game.getState());

//        GameData gameData = new GameData(game.getId(), game.getBet(), game.getPlayerHand(),
//                game.getDealerHand(), game.getUserName(), game.getState());

        if(dealerHand.handValue() > 21){
//            chipsService.depositChips(username, game.getBet() * 2);
            state = GameStates.won;

        } else {
            if (playerHand.handValue() > dealerHand.handValue()) {
//                chipsService.depositChips(username, game.getBet() * 2);
                state = GameStates.won;

            } else if (playerHand.handValue() < dealerHand.handValue()){
                state = GameStates.lost;

            } else {
//                chipsService.depositChips(username, game.getBet());
                state = GameStates.push;
            }
        }
    }

    public void doubleDown(){
        if (!state.equals(on_going)) {
            throw new NotAllowedException();
        }
//        GameData gameData = new GameData(game.getId(), game.getBet(), game.getPlayerHand(), game.getDealerHand(), game.getUserName(), game.getState());

        this.hit();
        playerHand.checkAceValue();

        if(playerHand.handValue() > 21){
            state = GameStates.bust;
        }

    }

    public void surrender(){
        if (!state.equals(on_going)) {
            throw new NotAllowedException();
        }
//        GameData gameData = new GameData(game.getId(), game.getBet(), game.getPlayerHand(),
//                game.getDealerHand(), game.getUserName(), game.getState());

//        chipsService.depositChips(username, game.getBet() / 2 );
        state = GameStates.resigned;
    }

//    public boolean checkBust(Hand hand){
//        if(Game.getHandValue(hand) > 21){
//            return true;
//        } else {
//            return false;
//        }
//    }

//    public boolean checkBlackJack(Hand hand){
//       if(Game.getHandValue(hand) == 21){
//           return true;
//       } else {
//           return false;
//       }
//    }
//
//    public boolean checkDealerHand(Hand hand){
//        int i = Game.getHandValue(hand);
//        while( i <= 16){
//            i++;
//            return true;
//        } return false;
//    }
//
//    public String checkWon(Hand playerHand, Hand dealerHand) {
//        if(Game.getHandValue(playerHand) > Game.getHandValue(dealerHand)) {
//            return "win";
//        } else if ((Game.getHandValue(playerHand) < Game.getHandValue(dealerHand))){
//            return "lost";
//        }
//            return "push";
//        }

}
