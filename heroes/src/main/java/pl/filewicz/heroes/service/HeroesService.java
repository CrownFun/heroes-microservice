package pl.filewicz.heroes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.filewicz.heroes.controller.client.HeroesRestClient;
import pl.filewicz.heroes.model.Army;
import pl.filewicz.heroes.model.Castle;
import pl.filewicz.heroes.model.Creatures;
import pl.filewicz.heroes.model.Heroes;
import pl.filewicz.heroes.model.Weapon;
import pl.filewicz.heroes.repository.HeroesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroesService {

    private final HeroesRestClient heroesRestClient;
    private final HeroesRepository heroesRepository;

    public Heroes createHeroes(String heroesName, String castleName, String weaponName, String creature1, String creature2, String creature3) {
        Castle castle = heroesRestClient.getCastle(castleName);
        Weapon weapon = heroesRestClient.getWeapon(weaponName);
        Heroes heroes = new Heroes(heroesName, weapon, createArmy(creature1, creature2, creature3), castle);
        heroesRepository.getHeroesList().add(heroes);
        System.out.println("zapisano herosa do listy " + heroesRepository.getHeroesList());
        return heroes;
    }

    private Army createArmy(String name1, String name2, String name3) {
        List<Creatures> creatures = List.of(
                heroesRestClient.getCreature(name1),
                heroesRestClient.getCreature(name2),
                heroesRestClient.getCreature(name3)
        );
        return new Army(creatures);
    }

    public Heroes getHeroesByName(String heroesName){
        Heroes heroesFromList = heroesRepository.getHeroesFromList(heroesName);
        System.out.println("pobrano herosa z listy " + heroesFromList.getName());
        return heroesFromList;
    }

    public List<Heroes> getAllHeroesFromList(){
        return heroesRepository.getHeroesList();
    }


}
