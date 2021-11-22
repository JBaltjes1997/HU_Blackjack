package nl.hu.bep2.casino.blackjack.presentation;


import nl.hu.bep2.casino.blackjack.application.BlackjackService;
import nl.hu.bep2.casino.blackjack.application.GameData;
import nl.hu.bep2.casino.blackjack.presentation.Dto.BetDto;
import nl.hu.bep2.casino.security.domain.UserProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

//    public GameDto showCards(Game game){
//
//        GameDto dto = new GameDto();
//
//        dto.playerHand = game.getPlayer().getHand().getCards();
//        dto.dealerHand = game.getDealer().getHand().getCards();
//        dto.id = game.getId();
//        dto.bet = game.getBet();
//
//        return dto;
//    }

    @PostMapping
    public GameData startGame(Authentication authenticate, @Validated  @RequestBody BetDto betDto){
        UserProfile profile = (UserProfile) authenticate.getPrincipal();
        String username = profile.getUsername();

        return service.startGame(profile.getUsername(), betDto.value);
    }

    @PostMapping("game/{id}/hit")
    public GameData hit(Authentication authentication, @Validated @PathVariable Long id){
        String username = parseUsername(authentication);

        return this.service.hit(username, id);

    }

    private String parseUsername(Authentication authentication) {
        UserProfile profile = (UserProfile) authentication.getPrincipal();
        return profile.getUsername();
    }


//    hit
//aan de bestaande game iets toevoegen



//    @PutMapping("/id")
//    public GameDto hit(Authentication authenticate, @PathVariable Long id) {
//        Game game = service.hit(id);
//        return showCards(game);
//    }

}
