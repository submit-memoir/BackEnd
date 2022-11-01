package com.example.memoir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MemoirApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemoirApplication.class, args);
	}

}
