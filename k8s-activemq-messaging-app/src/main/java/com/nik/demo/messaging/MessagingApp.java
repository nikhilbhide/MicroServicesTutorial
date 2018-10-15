package com.nik.demo.messaging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the spring boot bootstrap class that starts the Spring Boot Container
 * @author nikhil.bhide
 *
 */

@SpringBootApplication
public class MessagingApp {

	public static void main(String[] args) {
		SpringApplication.run(MessagingApp.class, args);
	}
}