package com.filewicz.combat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CombatApplication {

    public static void main(String[] args) {
        SpringApplication.run(CombatApplication.class, args);
    }

}
