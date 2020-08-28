package pl.filewicz.heroes.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.filewicz.heroes.model.Castle;
import pl.filewicz.heroes.model.Creatures;
import pl.filewicz.heroes.model.Weapon;

@RequiredArgsConstructor
@Component
public class HeroesRestClient {

    private final static String CASTLE_URL = "http://localhost:8084/api/castle/";
    private final static String WEAPON_URL = "http://localhost:8085/api/weapon/";
    private final static String CREATURE_URL = "http://localhost:8086/api/creature/";

    private final RestTemplate restTemplate;

    public Castle getCastle(String name) {
        return restTemplate.getForObject(CASTLE_URL + name, Castle.class);
    }

    public Weapon getWeapon(String name) {
        return restTemplate.getForObject(WEAPON_URL + name, Weapon.class);
    }

    public Creatures getCreature(String name) {
        return restTemplate.getForObject(CREATURE_URL + name, Creatures.class);
    }

}
