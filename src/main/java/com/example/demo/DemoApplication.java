package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	private static final org.apache.logging.log4j.Logger LOGGER = org.apache.logging.log4j.LogManager
			.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		LOGGER.info("INICIANDO...");
		SpringApplication.run(DemoApplication.class, args);
	}

}
