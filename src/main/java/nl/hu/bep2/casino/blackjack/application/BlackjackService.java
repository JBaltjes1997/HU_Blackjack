package nl.hu.bep2.casino.blackjack.application;


import nl.hu.bep2.casino.blackjack.domain.Dealer;
import nl.hu.bep2.casino.blackjack.domain.Game;
import nl.hu.bep2.casino.blackjack.domain.Player;
import nl.hu.bep2.casino.blackjack.presentation.Bet;
import nl.hu.bep2.casino.blackjack.presentation.Dto.GameDto;
import nl.hu.bep2.casino.chips.application.ChipsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BlackjackService {
    private ChipsService chipsService;

    public BlackjackService(ChipsService chipsService){this.chipsService = chipsService;}

    public Game startGame(String username, Long bet){
        chipsService.withdrawChips(username, bet);
        Game game = new Game(username, bet);
        game.startGame();
        return game;
    }

//    public Game hit(String username){
//        Game game = Game.getPlayerName();
//        game.dealOneCardToPlayer();
//        return game;
//    }

//    public Game stay(){
//        return null;
//    }








}
