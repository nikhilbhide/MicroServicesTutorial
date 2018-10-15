package com.nik.demo.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the Rest controller that exposes Rest Apis.
 * @author nikhil.bhide
 *
 */

@RestController
public class MessagingAppController {
	
	@Autowired
	JMSSender sender; 
	
	@RequestMapping("/send")
	public String sendMessage() {
		sender.send("test", "Test Message");
		return "success";
	}
}