package com.nik.tutorial.distributedtracing.FlightReservation;

import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class FlightReservationService {
	private static final Logger logger = LoggerFactory.getLogger(FlightReservationController.class);

	private final RestTemplate restTemplate;

	 public FlightReservationService(RestTemplate rest) {
		    this.restTemplate = rest;
		  }
	@HystrixCommand(fallbackMethod = "reliable")
	public String getHotel() {
		final String uri = "http://localhost:8083/hotel/reserve";
		String result = restTemplate.getForObject(uri, String.class);

		return result;
	}

	public String reliable() {
		return "You are Late as flight is full! Better luck next time..";
	}
}