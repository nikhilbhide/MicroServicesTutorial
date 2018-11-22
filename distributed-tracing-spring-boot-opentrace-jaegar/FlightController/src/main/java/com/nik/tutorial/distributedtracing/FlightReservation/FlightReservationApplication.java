package com.nik.tutorial.distributedtracing.FlightReservation;

import com.uber.jaeger.Configuration;
import com.uber.jaeger.samplers.ProbabilisticSampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FlightReservationApplication {

	 @Bean
	  public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
	    return restTemplateBuilder.build();
	  }

	 @Bean
		public io.opentracing.Tracer jaegarTracer() {
			return new Configuration("spring-boot", new Configuration.SamplerConfiguration(ProbabilisticSampler.TYPE, 1),
					new Configuration.ReporterConfiguration())
					.getTracer();
		}

	public static void main(String[] args) {
		SpringApplication.run(FlightReservationApplication.class, args);
	}
}