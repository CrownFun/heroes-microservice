package com.filewicz.combat.controller.api;

import com.filewicz.combat.exception.HeroesNotFoundException;
import com.filewicz.combat.model.Army;
import com.filewicz.combat.model.Castle;
import com.filewicz.combat.model.Heroes;
import com.filewicz.combat.model.Weapon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
@RequiredArgsConstructor
public class HeroesInfo {

    private final RestTemplate restTemplate;
    private final static String HEROES_URL = "http://heroes-service/api/heroes/";

    @HystrixCommand(fallbackMethod = "getHeroesFallbackMethod")
    public Heroes getHeroesClient(String heroesName) {
        try {
            return restTemplate.getForObject(HEROES_URL + heroesName, Heroes.class);
        } catch (RestClientException e) {
            throw new HeroesNotFoundException(heroesName);
        }
    }

    public Heroes getHeroesFallbackMethod(String heroesName) {
        return new Heroes("Default heroese name", new Weapon("Defoult weapon", Integer.MIN_VALUE, Integer.MIN_VALUE), new Army(), new Castle("Default Castle", "Default Castle"));
    }

}
