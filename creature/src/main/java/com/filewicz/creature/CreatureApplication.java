package com.filewicz.creature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CreatureApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreatureApplication.class, args);
    }

}
