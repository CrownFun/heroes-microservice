package pl.filewicz.heroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ConfigurableApplicationContext;
import pl.filewicz.heroes.model.Heroes;
import pl.filewicz.heroes.service.HeroesService;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class HeroesApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(HeroesApplication.class, args);
    }
}
