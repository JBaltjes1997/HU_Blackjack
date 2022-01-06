package nl.hu.bep2.casino.blackjack.presentation;


import nl.hu.bep2.casino.blackjack.application.BlackjackService;
import nl.hu.bep2.casino.blackjack.application.GameData;
import nl.hu.bep2.casino.blackjack.domain.Bet;
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

    @PostMapping
    public GameData startGame(Authentication authenticate, @Validated  @RequestBody BetDto betDto){
        UserProfile profile = (UserProfile) authenticate.getPrincipal();
        String username = profile.getUsername();

        return service.startGame(profile.getUsername(), betDto.value);
    }

    @PostMapping("/{id}/hit")
    public GameData hit(Authentication authentication, @Validated @PathVariable Long id){
        String username = parseUsername(authentication);

        return this.service.hit(username, id);
    }

    @PostMapping("/{id}/doubleDown")
    public GameData doubleDown(Authentication authentication, @Validated @PathVariable Long id){
        String username = parseUsername(authentication);

        return this.service.doubleDown(username, id);
    }

    @PostMapping("/{id}/stay")
    public GameData stay(Authentication authentication, @Validated @PathVariable Long id){
        String username = parseUsername(authentication);

        return this.service.stay(username, id);
    }

    @PostMapping("/{id}/surrender")
    public GameData surrender(Authentication authentication, @Validated @PathVariable Long id){
        String username = parseUsername(authentication);

        return this.service.surrender(username, id);
    }

    private String parseUsername(Authentication authentication) {
        UserProfile profile = (UserProfile) authentication.getPrincipal();
        return profile.getUsername();
    }
}
