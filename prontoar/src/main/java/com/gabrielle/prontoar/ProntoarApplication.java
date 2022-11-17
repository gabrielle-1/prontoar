package com.gabrielle.prontoar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// @SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
public class ProntoarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProntoarApplication.class, args);
	}

}
