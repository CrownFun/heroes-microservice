package pl.filewicz.heroes.controller;

import org.springframework.http.ResponseEntity;
import pl.filewicz.heroes.model.Heroes;

import java.util.List;

public interface HeroesRestController {

    ResponseEntity<Heroes> getHeroesByName(String heroesName);

    ResponseEntity<List<Heroes>> getAllHeroes();

    ResponseEntity<Heroes> createHeroes(String heroesName, String castleName, String weaponName, String creature1,String creature2,String creature3 );

}
