package com.filewicz.combat.controller.api;

import com.filewicz.combat.model.Heroes;
import com.filewicz.combat.service.CombatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

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

        Heroes hero1 = null;
        Heroes hero2 = null;

        hero1 = heroesExistanceValidate(heroes1);
        if (statusCodeValue == 404) {
            statusCodeValue = 200;
            return "Heroes with name " + heroes1 + " not found";
        } else if (statusCodeValue == 200) {
            hero2 = heroesExistanceValidate(heroes2);
            if (statusCodeValue == 404) {
                statusCodeValue = 200;
                return "Heroes with name " + heroes2 + " not found";
            }
        }
        return combatService.fight(hero1, hero2);
    }

    private Heroes heroesExistanceValidate(String heroesName) {
        Heroes heroes = null;
        try {
            heroes = restTemplate.getForObject(HEROES_URL + heroesName, Heroes.class);
        } catch (HttpStatusCodeException e) {
            statusCodeValue = e.getStatusCode().value();
        }
        return heroes;
    }
}
