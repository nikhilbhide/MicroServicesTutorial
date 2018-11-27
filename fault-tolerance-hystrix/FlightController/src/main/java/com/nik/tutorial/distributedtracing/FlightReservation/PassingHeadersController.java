package com.nik.tutorial.distributedtracing.FlightReservation;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PassingHeadersController {

  @Autowired
  private RestTemplate restTemplate;

  @RequestMapping(value = "/hello2")
  public String hello() {
    return "Hello from Spring Boot!";
  }

  @RequestMapping("/chaining2")
  public String chaining(@RequestHeader HttpHeaders headers) {
    HttpHeaders tracingHeaders = new HttpHeaders();
    extractHeader(headers, tracingHeaders, "x-request-id");
    extractHeader(headers, tracingHeaders, "x-b3-traceid");
    extractHeader(headers, tracingHeaders, "x-b3-spanid");
    extractHeader(headers, tracingHeaders, "x-b3-parentspanid");
    extractHeader(headers, tracingHeaders, "x-b3-sampled");
    extractHeader(headers, tracingHeaders, "x-b3-flags");
    extractHeader(headers, tracingHeaders, "x-ot-span-context");

    ResponseEntity<String> response = restTemplate
        .exchange("http://localhost:8083/hotel/reserve", HttpMethod.GET, new HttpEntity<>(tracingHeaders), String.class);

    return "Chaining + " + response.getBody();
  }

  private static void extractHeader(HttpHeaders headers, HttpHeaders extracted, String key) {
    List<String> vals = headers.get(key);
    if (vals != null && !vals.isEmpty()) {
      extracted.put(key, Arrays.asList(vals.get(0)));
    }
  }
}
