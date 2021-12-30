package com.kaur.vandana.microservices.currencyexchangeservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    public String sampleApi() {
        logger.info("/sample-api call received");
        ResponseEntity<String> forEntity =
                new RestTemplate().getForEntity("http://localhost:8000/some-url", String.class);
        return forEntity.getBody();
    }

    public String hardcodedResponse(Exception e) {
        return "Fallback-response";
    }

    /*@GetMapping("/sample-api")
    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
    public String sampleApi() {
        logger.info("/sample-api call received");
        ResponseEntity<String> forEntity =
                new RestTemplate().getForEntity("http://localhost:8000/some-url", String.class);
        return forEntity.getBody();
    }

    public String hardcodedResponse(Exception e) {
        return "Fallback-response";
    }*/

   /* @GetMapping("/sample-api")
    public String sampleApi() {
        logger.info("/sample-api call received");
        ResponseEntity<String> forEntity =
                new RestTemplate().getForEntity("http://localhost:8000/some-url", String.class);
        return forEntity.getBody();
    }*/


}
