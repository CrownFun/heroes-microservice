package pl.filewicz.heroes.repository;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.filewicz.heroes.exceptions.HeroesNotFoundException;
import pl.filewicz.heroes.model.Heroes;

import java.util.ArrayList;
import java.util.List;

@Repository
@Data
@NoArgsConstructor
public class HeroesRepository {

    private List<Heroes> heroesList = new ArrayList<>();

    public HeroesRepository(List<Heroes> heroesList) {
        this.heroesList = heroesList;
    }

    public Heroes getHeroesFromList(String name) {
        return heroesList.stream()
                .filter(heroes -> heroes.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new HeroesNotFoundException(name));
    }
}
