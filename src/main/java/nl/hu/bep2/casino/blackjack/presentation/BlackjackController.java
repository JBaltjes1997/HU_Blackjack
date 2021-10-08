package nl.hu.bep2.casino.blackjack.presentation;


import nl.hu.bep2.casino.blackjack.application.BlackjackService;
import nl.hu.bep2.casino.blackjack.domain.Game;
import nl.hu.bep2.casino.blackjack.domain.Move;
import nl.hu.bep2.casino.blackjack.presentation.Dto.BetDto;
import nl.hu.bep2.casino.blackjack.presentation.Dto.GameDto;
import nl.hu.bep2.casino.security.domain.UserProfile;
import org.apache.catalina.Service;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import javax.validation.Valid;

@RestController
@RequestMapping("/BlackJack")
public class BlackjackController {
    private final BlackjackService service;

    public BlackjackController(BlackjackService service) {
        this.service = service;
    }

    @GetMapping("/Bets")
    public ResponseEntity<Void> testBet(@Valid @RequestBody Bet bet){
        return null;
    }

    public GameDto showCards(Game game){
        GameDto dto = new GameDto();
        dto.playerHand = game.getPlayer().getHand();
        dto.dealerHand = game.getDealer().getHand();
        dto.id = game.getId();
        dto.bet = game.getBet();
        return dto;
    }

    @GetMapping("/start")
    public GameDto startGame( Authentication authenticate, @RequestBody BetDto betDto){
        UserProfile profile = (UserProfile) authenticate.getPrincipal();
        Game game = service.startGame(profile.getUsername(), betDto.value);
        return showCards(game);
    }

}
