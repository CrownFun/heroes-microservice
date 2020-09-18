package pl.filewicz.heroes.controller.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.filewicz.heroes.exceptions.HeroesNotFoundException;
import pl.filewicz.heroes.model.Heroes;
import pl.filewicz.heroes.service.HeroesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RefreshScope
public class HeroesRestControllerImpl implements HeroesRestController {
    @Value("${info.property}")
    private String property;
    private final HeroesService heroesService;

    @Override
    @GetMapping("/{heroesName}")
    public ResponseEntity<Heroes> getHeroesByName(@PathVariable String heroesName) {
        return Optional.ofNullable(heroesService.getHeroesByName(heroesName))
                .map(heroes -> new ResponseEntity<>(heroes, HttpStatus.OK))
                .orElseThrow(() -> new HeroesNotFoundException(heroesName));
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<Heroes>> getAllHeroes() {
        List<Heroes> allHeroesFromList = heroesService.getAllHeroesFromList();
        if (allHeroesFromList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allHeroesFromList, HttpStatus.OK);
    }

    @Override
    @PostMapping("/create")
    //http://localhost:8087/api/heroes/create?heroesName=Kosiarz&castleName=LOCHY&weaponName=Miecz&creature1=Cyklop&creature2=Behemot&creature3=Goblin
    public ResponseEntity<Heroes> createHeroes(@RequestParam String heroesName, @RequestParam String castleName, @RequestParam String weaponName,
                                               @RequestParam String creature1, @RequestParam String creature2, @RequestParam String creature3) {
        return Optional.ofNullable(heroesService.createHeroes(heroesName, castleName, weaponName, creature1, creature2, creature3))
                .map(heroes -> new ResponseEntity<>(heroes, HttpStatus.CREATED))
                .orElse(ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build());
    }

    @GetMapping("/message")
    String property() {
        return property;
    }
}
