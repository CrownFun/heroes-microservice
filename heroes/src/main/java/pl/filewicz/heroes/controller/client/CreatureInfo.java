package pl.filewicz.heroes.controller.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.filewicz.heroes.exceptions.CreatureNotFoundException;
import pl.filewicz.heroes.exceptions.CreatureServiceException;
import pl.filewicz.heroes.model.Creatures;

@Service
@RequiredArgsConstructor
public class CreatureInfo {

    private final static String CREATURE_URL = "http://creatures-service/api/creature/";

    private final RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackCreatureMethod")
    public Creatures getCreature(String name) {
        try {
            return restTemplate.getForObject(CREATURE_URL + name, Creatures.class);
        } catch (HttpClientErrorException e) {
            System.out.println("Przechwytuje błąd creature not found");
            if (e.getStatusCode().value() == HttpStatus.NOT_FOUND.value())
                throw new CreatureNotFoundException(name);
            else
                throw new CreatureServiceException(e.getStatusCode().value());
        }
    }

    public Creatures getFallbackCreatureMethod(String name){
        return new Creatures("Default creature name",Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE);
    }

}
