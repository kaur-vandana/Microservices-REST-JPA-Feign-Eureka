package com.kaur.vandana.microservices.currencyconversationservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//we usually write te application name and url, we are using
//@FeignClient(name = "currency-exchange", url = "localhost:8001")
//Client side load balancing
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversation retrieveExchangeValue_repository(
            @PathVariable String from,
            @PathVariable String to);
}
