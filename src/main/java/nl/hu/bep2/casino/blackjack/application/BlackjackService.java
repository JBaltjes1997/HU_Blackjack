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

        this.repository.save(game);

        GameData gameData = new GameData(game.getId(), game.getBet(), game.getPlayerHand(), game.getDealerHand(), game.getUserName());

        if(game.checkBlackJack(game.getPlayerHand()) == true){
            chipsService.depositChips(username, (long) (bet*1.5));
            System.out.println("Congratulations. You won!");
            // moet nog toevoegen dat een bericht in postman komt
            // tip van anderen, voeg een game status toe die showt of je wel/niet gewonnen hebt en daarna ook een terminate uitvoert
        }
        return gameData;
    }

    public GameData hit(String username, Long id){
        Game game = this.repository.findByUserNameAndId(username, id).orElseThrow(() -> new GameNotFoundException());

        game.playerHit();

        if(game.checkBust(game.getPlayerHand()) == true){
            System.out.println("Sorry, you got above 21. You lost :( ");
            // to-be-add-on, a terminate request
        }

        return new GameData(game.getId(), game.getBet(), game.getPlayerHand(), game.getDealerHand(), game.getUserName());
    }

    public GameData stay(String username, Long id){
        Game game = this.repository.findByUserNameAndId(username, id).orElseThrow(() -> new GameNotFoundException());

        game.dealerHit();
        if(game.checkDealerHand(game.getDealerHand()) == true){
            game.dealerHit();
        }

        if(game.checkBust(game.getDealerHand()) == true){
            chipsService.depositChips(username, game.getBet() * 2);
            System.out.println("The dealer busted, you have won!");
            // to-be-add-on, a terminate request

        } else {
            if (game.checkWon(game.getPlayerHand(), game.getDealerHand()) == "win") {
                chipsService.depositChips(username, game.getBet() * 2);
                System.out.println("Congratulations. You won!");

            } else if (game.checkWon(game.getPlayerHand(), game.getDealerHand()) == "tie"){
                chipsService.depositChips(username, game.getBet());
                System.out.println("It's a draw, no win and no gain");

            }
            System.out.println("Sorry, you lost :( ");
        }

        return new GameData(game.getId(), game.getBet(), game.getPlayerHand(), game.getDealerHand(), game.getUserName());
    }
}
