package com.kaur.vandana.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversion {
    private Long id;
    private String currencyfrom;
    private String currencyto;
    private BigDecimal quantity;
    private BigDecimal conversionMultiple;
    private BigDecimal totalCalculatedAmount;
    private String environment;

    public CurrencyConversion() {
    }

    public CurrencyConversion(Long id, String currencyfrom, String currencyto, BigDecimal quantity,
                              BigDecimal conversionMultiple, BigDecimal totalCalculatedAmount, String environment) {
        this.id = id;
        this.currencyfrom = currencyfrom;
        this.currencyto = currencyto;
        this.quantity = quantity;
        this.conversionMultiple = conversionMultiple;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.environment = environment;
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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
