package com.kaur.vandana.microservices.currencyconversationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConversationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversationServiceApplication.class, args);
	}

}
