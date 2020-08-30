package pl.filewicz.heroes.controller.client;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.filewicz.heroes.exceptions.CastleNotFoundException;
import pl.filewicz.heroes.exceptions.CastleServiceException;
import pl.filewicz.heroes.exceptions.CreatureNotFoundException;
import pl.filewicz.heroes.exceptions.CreatureServiceException;
import pl.filewicz.heroes.exceptions.WeaponNotFoundException;
import pl.filewicz.heroes.exceptions.WeaponServiceException;
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
        try {
            return restTemplate.getForObject(CASTLE_URL + name, Castle.class);
        } catch (HttpStatusCodeException e) {
            if (e.getStatusCode().value() == HttpStatus.NOT_FOUND.value())
                throw new CastleNotFoundException(name);
            else
                throw new CastleServiceException(e.getStatusCode().value());
        }
    }

    public Weapon getWeapon(String name) {
        try {
            return restTemplate.getForObject(WEAPON_URL + name, Weapon.class);
        } catch (HttpStatusCodeException e) {
            if (e.getStatusCode().value() == HttpStatus.NOT_FOUND.value())
                throw new WeaponNotFoundException(name);
            else
                throw new WeaponServiceException(e.getStatusCode().value());
        }
    }

    public Creatures getCreature(String name) {
        try {
            return restTemplate.getForObject(CREATURE_URL + name, Creatures.class);
        } catch (HttpStatusCodeException e) {
            if (e.getStatusCode().value() == HttpStatus.NOT_FOUND.value())
                throw new CreatureNotFoundException(name);
            else
                throw new CreatureServiceException(e.getStatusCode().value());
        }
    }
}
