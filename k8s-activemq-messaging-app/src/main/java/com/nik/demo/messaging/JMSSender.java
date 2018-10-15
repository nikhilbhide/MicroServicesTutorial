package com.nik.demo.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * JMSSender class provides capability to send the message using {@link JmsTemplate}.
 * @author nikhil.bhide
 *
 */

@Component
public class JMSSender {
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Value("${spring.activemq.sender.queue}")
	String destination;
	
	public void send(String destination, String message) {
		jmsTemplate.convertAndSend(destination, message);
	}
}