package pl.filewicz.heroes.controller.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.filewicz.heroes.config.RestConfig;
import pl.filewicz.heroes.exceptions.CastleNotFoundException;
import pl.filewicz.heroes.exceptions.CastleServiceException;
import pl.filewicz.heroes.model.Castle;

@Service
@RequiredArgsConstructor
public class CastleInfo {

    private final static String CASTLE_URL = "http://localhost:8089/api/castle/";

    private final RestConfig restConfig;

    @HystrixCommand(fallbackMethod = "getFallbackCastleMethod")
    public Castle getCastle(String name) {
        try {
            RestTemplate restTemplate = restConfig.getRestTemplate();
            Castle forObject = restTemplate.getForObject(CASTLE_URL + name, Castle.class);
            System.out.println("zameczek " + forObject);
            return forObject;
        } catch (HttpClientErrorException e) {
            System.out.println("Przechwytuje błąd castle not found ");
            if (e.getStatusCode().value() == HttpStatus.NOT_FOUND.value())
                throw new CastleNotFoundException(name);
            else
                throw new CastleServiceException(e.getStatusCode().value());
        }
    }

    public Castle getFallbackCastleMethod(String name) {
        return new Castle("Hystix Fallback - Castle", "Hystrix Fallback - Castle description ");
    }
}
