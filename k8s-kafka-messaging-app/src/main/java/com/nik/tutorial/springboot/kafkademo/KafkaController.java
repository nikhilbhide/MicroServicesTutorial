package com.nik.tutorial.springboot.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the Rest controller that exposes Rest Apis.
 * @author nikhil.bhide
 *
 */

@RestController
public class KafkaController {
	@Autowired 
	Producer producer;
	
	@GetMapping("/kafka-service")
	public String sendMessage() {
		return producer.send();
	}
}