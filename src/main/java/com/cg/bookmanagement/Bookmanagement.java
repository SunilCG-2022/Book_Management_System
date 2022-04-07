package com.cg.bookmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Bookmanagement {

	public static void main(String[] args) {
		SpringApplication.run(Bookmanagement.class, args);
	}
}
