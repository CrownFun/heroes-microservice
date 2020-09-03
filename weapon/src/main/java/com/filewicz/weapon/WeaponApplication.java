package com.filewicz.weapon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WeaponApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeaponApplication.class, args);
    }

}
