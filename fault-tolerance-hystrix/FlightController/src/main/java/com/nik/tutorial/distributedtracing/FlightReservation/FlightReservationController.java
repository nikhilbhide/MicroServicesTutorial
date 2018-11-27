package com.nik.tutorial.distributedtracing.FlightReservation;

import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/flight")
public class FlightReservationController{
	private static final Logger logger = LoggerFactory.getLogger(FlightReservationService.class);

	@Autowired
	RestTemplate restTemplate;

	
	@RequestMapping("/reserve")
	public String bookFlight() {
		System.out.print("\nRequest has received at time stamp");
		getHotel();
		logger.info("Flight is booked");
		return "Flight Booked";
	}
	
	private String getHotel() {
		final String uri = "http://localhost:8083/hotel/reserve";
		String result = restTemplate.getForObject(uri, String.class);
		
		return result;
	}
	

}