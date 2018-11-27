package com.nik.tutorial.distributedtracing.FlightReservation;

import com.uber.jaeger.Configuration;
import com.uber.jaeger.samplers.ProbabilisticSampler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@EnableCircuitBreaker
@SpringBootApplication
@RestController

public class FlightReservationApplication {
	@Autowired
	FlightReservationService flightService;
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

	@Bean
	public io.opentracing.Tracer jaegarTracer() {
		return new Configuration("flight-reservation-spring-boot", new Configuration.SamplerConfiguration(ProbabilisticSampler.TYPE, 1),
				new Configuration.ReporterConfiguration())
				.getTracer();
	}

	@RequestMapping("/reservewithsytrix")
	public String bookFlightWithHystrix() {
		return flightService.getHotel();
	}

	public static void main(String[] args) {
		SpringApplication.run(FlightReservationApplication.class, args);
	}
}