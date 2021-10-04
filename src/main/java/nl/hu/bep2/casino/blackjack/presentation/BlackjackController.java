package nl.hu.bep2.casino.blackjack.presentation;


import nl.hu.bep2.casino.blackjack.domain.Move;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/BlackJack")
public class BlackjackController {


    @GetMapping("/test")
    public ResponseEntity<Void> test(@Valid @RequestBody Bet bet){
        return null;
    }

}
