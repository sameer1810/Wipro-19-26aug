package com.sam.currencyconversionservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.sam.currencyconversionservice.model.CurrencyConversionBean;

public interface CurrencyExchangeServiceProxy {

@FeignClient(name="currency-exchange-service",url="localhost:8000")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable String from, 
			@PathVariable String to);
}