package nl.hu.bep2.casino.blackjack.application;


import nl.hu.bep2.casino.blackjack.data.GameRepository;

import nl.hu.bep2.casino.blackjack.domain.Game;
import nl.hu.bep2.casino.blackjack.domain.Hand;
import nl.hu.bep2.casino.blackjack.presentation.Bet;
import nl.hu.bep2.casino.blackjack.presentation.Dto.GameDto;
import nl.hu.bep2.casino.chips.application.ChipsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BlackjackService {
    private ChipsService chipsService;
    private final GameRepository repository;

    public BlackjackService(ChipsService chipsService, GameRepository repository ){
        this.chipsService = chipsService;
        this.repository = repository;
    }

    public GameData startGame(String username, Long bet){ // na elke stap, saven in de database. Move uitvoeren, upslaan en door

        Game game = new Game(username, bet);

        chipsService.withdrawChips(username, bet);

        game.startGame(username, bet);

//        if(game.checkBlackJack() ){
//            return chipsService.depositChips(username, (long) (bet*1.5));
//            return game;
//        }

        this.repository.save(game);

        return new GameData(game.getId(), game.getBet(), game.getPlayerHand(), game.getDealerHand(), game.getUserName());
    }

    public GameData hit(String username, Long id){
        Game game = this.repository.findByUserNameAndId(username, id).orElseThrow(() -> new GameNotFoundException());

        return new GameData(game.getId(), game.getBet(), game.getPlayerHand(), game.getDealerHand(), game.getUserName());
//        return new GameData(game.playererHit());
    }




//    public GameDto showCards(Game game){
//        GameDto dto = new GameDto();
//
//        dto.playerHand = game.getPlayer().getHand().getCards();
//        dto.dealerHand = game.getDealer().getHand().getCards();
//        dto.id = game.getId();
//
//        return dto;
//    }
}
