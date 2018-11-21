package com.nik.tutorial.microservices.HelloWorld;

import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backend")
public class BackEndController {
		private static final Logger logger = LoggerFactory.getLogger(BackEndController.class);

	@RequestMapping("/quote")
	private Quote getQuote() {
		logger.info("\nRequest has received at backend time stamp {} ",LocalTime.now());
		Quote quote = new Quote();
		quote.setType("Exchange Rate");
		Value value = new Value();
		value.setId((long) 10000);
		value.setQuote("74.25");
		quote.setValue(value);
		return quote;
	}
}