package com.nik.tutorial.microservices.HelloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@RequestMapping("/welcome")
	private String welcome() {
		return "Welcome to MSA World!";
	}
}