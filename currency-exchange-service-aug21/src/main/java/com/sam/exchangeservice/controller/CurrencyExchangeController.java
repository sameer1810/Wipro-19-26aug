package com.sam.exchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sam.exchangeservice.entity.ExchangeValue;
import com.sam.exchangeservice.repository.ExchangeValueRepository;


@RestController
public class CurrencyExchangeController {

	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository exchValueRepo;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		ExchangeValue exchangeValue = exchValueRepo.findByFromAndTo(from, to);
		
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
}
