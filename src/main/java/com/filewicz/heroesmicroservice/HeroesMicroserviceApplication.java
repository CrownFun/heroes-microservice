package com.filewicz.heroesmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HeroesMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeroesMicroserviceApplication.class, args);
	}
}
