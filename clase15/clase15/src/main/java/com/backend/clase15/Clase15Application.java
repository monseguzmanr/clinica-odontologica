package com.backend.clase15;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Clase15Application {

	private static Logger logger = LoggerFactory.getLogger(Clase15Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Clase15Application.class, args);

		logger.info("Clase15 is now running...");
	}


}
