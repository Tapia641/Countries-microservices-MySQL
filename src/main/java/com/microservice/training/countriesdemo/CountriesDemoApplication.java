package com.microservice.training.countriesdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CountriesDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountriesDemoApplication.class, args);
	}

}
