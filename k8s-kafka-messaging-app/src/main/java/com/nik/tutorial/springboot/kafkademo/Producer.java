package com.nik.tutorial.springboot.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * This class is kafka message producer. It uses {@link KafkaTemplate} to produce the message.
 * 
 * @author nikhil.bhide
 */

@Service
public class Producer {
	@Autowired
	private KafkaTemplate kafkaTemplate;
	private String kafkaTopic = "testing";

	public String send() {
		kafkaTemplate.send(kafkaTopic, "test message - " );
		return "success";
	}
}