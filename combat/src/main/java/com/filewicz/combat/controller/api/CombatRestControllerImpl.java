package com.filewicz.combat.controller.api;

import com.filewicz.combat.exception.HeroesNotFoundException;
import com.filewicz.combat.model.Heroes;
import com.filewicz.combat.service.CombatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
@RequestMapping("/api/combat")
@RequiredArgsConstructor
public class CombatRestControllerImpl {

    private final static String HEROES_URL = "http://localhost:8087/api/heroes/";

    private final CombatService combatService;
    private final RestTemplate restTemplate;
    private int statusCodeValue = 200;

    @GetMapping("/fight")
    //http://localhost:8088/api/combat?heroes1=Benq&heroes2=Fendt
    public String fight(@RequestParam String heroes1, @RequestParam String heroes2) {
        return combatService.fight(heroesExistanceValidate(heroes1), heroesExistanceValidate(heroes2));
    }

    private Heroes heroesExistanceValidate(String heroesName) {
        try {
            return restTemplate.getForObject(HEROES_URL + heroesName, Heroes.class);
        } catch (RestClientException e) {
            throw new HeroesNotFoundException(heroesName);
        }
    }
}
