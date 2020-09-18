package com.filewicz.combat.controller.api;

import com.filewicz.combat.model.Heroes;
import com.filewicz.combat.service.CombatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RefreshScope
public class CombatRestControllerImpl {

    @Value("${info.property}")
    private String property;

    private final CombatService combatService;
    private final HeroesInfo heroesInfo;


    @GetMapping("/fight")
    //http://localhost:8088/api/combat?heroes1=Benq&heroes2=Fendt
    public String fight(@RequestParam String heroes1, @RequestParam String heroes2) {
        return combatService.fight(getHeroes(heroes1), getHeroes(heroes2));
    }

    public Heroes getHeroes(String heroesName) {
        return heroesInfo.getHeroesClient(heroesName);
    }

    @GetMapping("/message")
    String property() {
        return property;
    }
}
