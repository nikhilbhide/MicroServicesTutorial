package com.nik.tutorial.springboot.kafkademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the spring boot bootstrap class that starts the Spring Boot Container
 * @author nikhil.bhide
 *
 */
@SpringBootApplication
public class KafkaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApplication.class, args);		
	}
}
