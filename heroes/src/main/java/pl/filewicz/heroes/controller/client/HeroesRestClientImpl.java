package pl.filewicz.heroes.controller.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.filewicz.heroes.model.Castle;
import pl.filewicz.heroes.model.Creatures;
import pl.filewicz.heroes.model.Weapon;

@RequiredArgsConstructor
@Component
//należy obslużyć sytuację w której serwis nie odpowiada, można się bawić w status code ale prawdopodbnie problem rozwiąze Hystrix
public class HeroesRestClientImpl implements HeroesRestClient {

    private final CastleInfo castleInfo;
    private final WeaponInfo weaponInfo;
    private final CreatureInfo creatureInfo;

    public Castle getCastle(String name) {
        return castleInfo.getCastle(name);
    }

    public Weapon getWeapon(String name) {
        return weaponInfo.getWeapon(name);
    }

    public Creatures getCreature(String name) {
        return creatureInfo.getCreature(name);
    }
}
