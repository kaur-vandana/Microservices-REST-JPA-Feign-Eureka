package com.kaur.vandana.microservices.currencyconversationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversationController {

    @Autowired
    private CurrencyExchangeProxy proxy;

    // with Rest Template
    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversation retrieveCurrencyConversation(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity) {

        HashMap<String, String> uriVariables = new HashMap();
        uriVariables.put("from",from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversation> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8001/currency-exchange/from/{from}/to/{to}",
                CurrencyConversation.class,
                uriVariables);

        CurrencyConversation currencyConversation = responseEntity.getBody();

        currencyConversation.setTotalCalculatedAmount(quantity.multiply(currencyConversation.getConversionMultiple()));

        return new CurrencyConversation(
                currencyConversation.getId(),
                from, to, quantity,
                currencyConversation.getConversionMultiple(),
                currencyConversation.getTotalCalculatedAmount(),
                currencyConversation.getEnvironment());
    }

// with feign
    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversation retrieveCurrencyConversationFeign(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity) {

        CurrencyConversation currencyConversation = proxy.retrieveExchangeValue_repository(from, to);

        return new CurrencyConversation(
                currencyConversation.getId(),
                from, to, quantity,
                currencyConversation.getConversionMultiple(),
                quantity.multiply(currencyConversation.getConversionMultiple()),
                currencyConversation.getEnvironment());
    }


}
