package com.nik.tutorial.microservices.HelloWorldConfigMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldConfigMapController {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldConfigMapController.class);

	@Value("${welcome.message:Welcome to our app}")
	private String welcomeMessage;
	
	@RequestMapping("/welcome")
	private String welcome() {
        String applicationName = System.getenv().getOrDefault("SPRING_BOOT_APP_ENV_CONFIG_APP_NAME", "Hello World");
        String description = System.getenv().getOrDefault("SPRING_BOOT_APP_ENV_CONFIG_APP_DESC", "Simple Application");
		logger.info("\napplication_name is {}",applicationName);
		logger.info("\ndescription is {}",description);
        return String.format(welcomeMessage,applicationName, description);
	}
}