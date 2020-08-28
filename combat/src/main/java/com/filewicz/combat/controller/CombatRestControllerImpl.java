package com.filewicz.combat.controller;

import com.filewicz.combat.model.Heroes;
import com.filewicz.combat.service.CombatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/combat")
@RequiredArgsConstructor
public class CombatRestControllerImpl {

    private final static String HEROES_URL = "http://localhost:8087/api/heroes/";

    private final CombatService combatService;
    private final RestTemplate restTemplate;


    @GetMapping("/fight")
    //http://localhost:8088/api/combat?heroes1=Benq&heroes2=Fendt
   public String fight(@RequestParam String heroes1,@RequestParam String heroes2){

        Heroes hero1 = restTemplate.getForObject(HEROES_URL + heroes1, Heroes.class);
        Heroes hero2 = restTemplate.getForObject(HEROES_URL + heroes2, Heroes.class);

        return combatService.fight(hero1,hero2);
   }
}
