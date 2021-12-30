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

import static nl.hu.bep2.casino.blackjack.application.GameStates.*;

@Service
@Transactional
public class BlackjackService {
    private ChipsService chipsService;
    private final GameRepository repository;

    public BlackjackService(ChipsService chipsService, GameRepository repository ){
        this.chipsService = chipsService;
        this.repository = repository;
    }

    public GameData startGame(String username, Long bet){

        Game game = new Game(username, bet);

        chipsService.withdrawChips(username, bet);

        game.startGame(username, bet);

        this.repository.save(game);

        GameData gameData = new GameData(game.getId(), game.getBet(), game.getPlayerHand(), game.getDealerHand(), game.getUserName(), game.getState());

        if(game.checkBlackJack(game.getPlayerHand()) == true){
            chipsService.depositChips(username, (long) (bet*1.5));
            gameData.setState(won);
        }
        return gameData;
    }

    public GameData hit(String username, Long id){
        Game game = this.repository.findByUserNameAndId(username, id).orElseThrow(() -> new GameNotFoundException());

        game.playerHit();
        game.checkAceValue();

        GameData gameData = new GameData(game.getId(), game.getBet(), game.getPlayerHand(), game.getDealerHand(), game.getUserName(), game.getState());

        if(game.checkBust(game.getPlayerHand()) == true){
            gameData.setState(bust);

        }

        return gameData;
    }

    public GameData stay(String username, Long id){
        Game game = this.repository.findByUserNameAndId(username, id).orElseThrow(() -> new GameNotFoundException());

        game.dealerHit();
        if(game.checkDealerHand(game.getDealerHand()) == true){
            game.dealerHit();
        }

        GameData gameData = new GameData(game.getId(), game.getBet(), game.getPlayerHand(), game.getDealerHand(), game.getUserName(), game.getState());

        if(game.checkBust(game.getDealerHand()) == true){
            chipsService.depositChips(username, game.getBet() * 2);
            gameData.setState(won);

        } else {
            if (game.checkWon(game.getPlayerHand(), game.getDealerHand()) == "win") {
                chipsService.depositChips(username, game.getBet() * 2);
                gameData.setState(won);

            } else if (game.checkWon(game.getPlayerHand(), game.getDealerHand()) == "lost"){
                gameData.setState(lost);

            } else {
                chipsService.depositChips(username, game.getBet());
                gameData.setState(tie);
            }
        }

        return gameData;
    }

    public GameData surrender(String username, Long id) {
        Game game = this.repository.findByUserNameAndId(username, id).orElseThrow(() -> new GameNotFoundException());

        GameData gameData = new GameData(game.getId(), game.getBet(), game.getPlayerHand(), game.getDealerHand(), game.getUserName(), game.getState());

        chipsService.depositChips(username, game.getBet() / 2 );
        gameData.setState(resigned);

        return gameData;
    }
}
