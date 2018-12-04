package com.nik.tutorial.microservices.HelloWorld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldSecretController {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldSecretController.class);

	@Value("${welcome.message}")
	private String message;

	@RequestMapping("/login")
	private String login() {
		String userName = System.getenv().getOrDefault("SECRETS_CRED_USER_NAME", "Admin");
		String accessToken = System.getenv().getOrDefault("SECRETS_CRED_USER_ACCESS_TOKEN", "Admin");
		logger.info("\nusername is {}",userName);
		logger.info("\naccessToken is {}",accessToken);
		return message;
	}
}