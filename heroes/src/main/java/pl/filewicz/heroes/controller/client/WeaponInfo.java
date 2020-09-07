package pl.filewicz.heroes.controller.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.filewicz.heroes.exceptions.WeaponNotFoundException;
import pl.filewicz.heroes.exceptions.WeaponServiceException;
import pl.filewicz.heroes.model.Weapon;

@Service
@RequiredArgsConstructor
public class WeaponInfo {

    private final static String WEAPON_URL = "http://weapon-service/api/weapon/";

    private final RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackWeaponMethod")
    public Weapon getWeapon(String name) {
        try {
            return restTemplate.getForObject(WEAPON_URL + name, Weapon.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().value() == HttpStatus.NOT_FOUND.value())
                throw new WeaponNotFoundException(name);
            else
                throw new WeaponServiceException(e.getRawStatusCode());
        }
    }

    public Weapon getFallbackWeaponMethod(String name) {
        return new Weapon("Default weapon name", Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

}
