package com.monster.comu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class ComuApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComuApplication.class, args);
	}

}
