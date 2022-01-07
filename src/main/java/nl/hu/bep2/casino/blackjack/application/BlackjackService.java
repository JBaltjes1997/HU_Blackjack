package nl.hu.bep2.casino.blackjack.application;


import nl.hu.bep2.casino.blackjack.data.GameRepository;

import nl.hu.bep2.casino.blackjack.domain.Game;
import nl.hu.bep2.casino.blackjack.domain.exceptions.GameNotFoundException;
import nl.hu.bep2.casino.chips.application.ChipsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

        if(game.getState() == GameStates.blackjack) {
            chipsService.depositChips(username, (long) (bet * 1.5));
        }

        this.repository.save(game);

        GameData gameData = new GameData(game.getId(), game.getBet(), game.getPlayerHand(),
                game.getDealerHand(), game.getUserName(), game.getState());

//        if(game.checkBlackJack(game.getPlayerHand())){
//            chipsService.depositChips(username, (long) (bet*1.5));
//            gameData.setState(won);
//        }


        return gameData;
    }


    public GameData hit(String username, Long id){
        Game game = this.repository.findByUserNameAndId(username, id).orElseThrow(GameNotFoundException::new);

        game.hit();

        this.repository.save(game);

        return new GameData(game.getId(),
                game.getBet(),
                game.getPlayerHand(),
                game.getDealerHand(),
                game.getUserName(),
                game.getState());
    }


    public GameData doubleDown(String username, Long id){
        Game game = this.repository.findByUserNameAndId(username, id).orElseThrow(GameNotFoundException::new); // hier word het spel opgehaald

        chipsService.withdrawChips(username, game.getBet());

        // moet nog 'bet' verdubbelen

//        GameData gameData = new GameData(game.getId(), game.getBet(), game.getPlayerHand(), game.getDealerHand(), game.getUserName(), game.getState());
//
//        game.playerHit();
//        game.checkAceValue(game.getPlayerHand());
//
//        if(game.checkBust(game.getPlayerHand())){
//            gameData.setState(bust);
//        }

        game.doubleDown();

        if(game.getState() == GameStates.won){
            chipsService.depositChips(username, game.getBet() * 2);
        } else if (game.getState() == GameStates.push){
            chipsService.depositChips(username, game.getBet());
        }

        this.repository.save(game);

        return this.stand(username, id);
    }

    public GameData stand(String username, Long id){
        Game game = this.repository.findByUserNameAndId(username, id).orElseThrow(GameNotFoundException::new);

//        game.dealerHit();
//        while(game.checkDealerHand(game.getDealerHand())){
//            game.dealerHit();
//        }
//        game.checkAceValue(game.getDealerHand());
//
//        GameData gameData = new GameData(game.getId(), game.getBet(), game.getPlayerHand(),
//                game.getDealerHand(), game.getUserName(), game.getState());
//
//        if(game.checkBust(game.getDealerHand())){
//            chipsService.depositChips(username, game.getBet() * 2);
//            gameData.setState(won);
//
//        } else {
//            if (game.checkWon(game.getPlayerHand(), game.getDealerHand()) == "win") {
//                chipsService.depositChips(username, game.getBet() * 2);
//                gameData.setState(won);
//
//            } else if (game.checkWon(game.getPlayerHand(), game.getDealerHand()) == "lost"){
//                gameData.setState(lost);
//
//            } else {
//                chipsService.depositChips(username, game.getBet());
//                gameData.setState(tie);
//            }
//        }

        game.stand();

        if(game.getState() == GameStates.won){
            chipsService.depositChips(username, game.getBet() * 2);
        } else if (game.getState() == GameStates.push){
            chipsService.depositChips(username, game.getBet());
        }

        this.repository.save(game);

        return new GameData(game.getId(),
                game.getBet(),
                game.getPlayerHand(),
                game.getDealerHand(),
                game.getUserName(),
                game.getState());
    }

    public GameData surrender(String username, Long id) {
        Game game = this.repository.findByUserNameAndId(username, id).orElseThrow(GameNotFoundException::new);

//        GameData gameData = new GameData(game.getId(), game.getBet(), game.getPlayerHand(),
//                game.getDealerHand(), game.getUserName(), game.getState());
//
//        chipsService.depositChips(username, game.getBet() / 2 );
//        gameData.setState(resigned);

        game.surrender();

        this.repository.save(game);

        return new GameData(game.getId(),
                game.getBet(),
                game.getPlayerHand(),
                game.getDealerHand(),
                game.getUserName(),
                game.getState());
    }
}
