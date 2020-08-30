package pl.filewicz.heroes.controller.client;

import pl.filewicz.heroes.model.Castle;
import pl.filewicz.heroes.model.Creatures;
import pl.filewicz.heroes.model.Weapon;

public interface HeroesRestClient {

    Weapon getWeapon(String weaponName);

    Castle getCastle(String castleName);

    Creatures getCreature(String creatureName);

}
