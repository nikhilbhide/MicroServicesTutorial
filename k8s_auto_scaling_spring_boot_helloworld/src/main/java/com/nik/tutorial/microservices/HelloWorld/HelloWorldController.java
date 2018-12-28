package com.nik.tutorial.microservices.HelloWorld;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@RequestMapping("/welcome")
	private String welcome() {
		System.out.format("\nRequest has received at time stamp %s ",LocalTime.now());
		return "Welcome to MSA World!";
	}
}