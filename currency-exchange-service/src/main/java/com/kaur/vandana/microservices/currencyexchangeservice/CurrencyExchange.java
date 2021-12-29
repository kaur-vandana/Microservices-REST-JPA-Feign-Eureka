package com.kaur.vandana.microservices.currencyexchangeservice;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class CurrencyExchange {

    @Id
    private Long id;

    private String currencyfrom;
    private String currencyto;
    private BigDecimal conversionMultiple;
    //returns the port number
    private String environment;

    public CurrencyExchange() {
    }

    public CurrencyExchange(Long id, String from, String to, BigDecimal conversionMultiple) {
        this.id = id;
        this.currencyfrom = from;
        this.currencyto = to;
        this.conversionMultiple = conversionMultiple;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyfrom() {
        return currencyfrom;
    }

    public void setCurrencyfrom(String currencyfrom) {
        this.currencyfrom = currencyfrom;
    }

    public String getCurrencyto() {
        return currencyto;
    }

    public void setCurrencyto(String currencyto) {
        this.currencyto = currencyto;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

}
