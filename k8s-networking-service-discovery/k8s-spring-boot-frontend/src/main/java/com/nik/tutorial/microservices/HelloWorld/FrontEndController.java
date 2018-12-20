package com.nik.tutorial.microservices.HelloWorld;

import java.time.LocalTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/frontend")
public class FrontEndController {
	@Value("${restUrl}")
	private String restUrl;
	
	private static final Logger logger = LoggerFactory.getLogger(FrontEndController.class);

	@RequestMapping("/quote")
	private Quote getQuote() {
		logger.info("\nRequest has received at front end time stamp {} ",LocalTime.now());
		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject(restUrl, Quote.class);
		return quote;
	}
}