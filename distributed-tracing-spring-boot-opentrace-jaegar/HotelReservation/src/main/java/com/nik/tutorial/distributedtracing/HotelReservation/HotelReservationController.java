package com.nik.tutorial.distributedtracing.HotelReservation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelReservationController {

	@RequestMapping("/reserve")
	public String bookHotel() {
		System.out.println("Hotel Reserved");
		return "Hotel Booked";
	}	
}