package com.sam.currencyconversionservice.controller;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.sam.currencyconversionservice.model.CurrencyConversionBean;
import com.sam.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/qty/{qty}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, 
			@PathVariable String to,
			@PathVariable BigDecimal qty) {
		
		CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
	
		response.setQuantity(qty);
		response.setTotalCalculatedAmount(qty.multiply(response.getConversionMultiple()));
		
		return response;
	/*@GetMapping("/currency-converter/from/{from}/to/{to}/qty/{qty}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, 
			@PathVariable String to,
			@PathVariable BigDecimal qty) {
		
		Map<String,String> uriVariables = new HashMap<>();
		
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversionBean> responseEntity = 
					new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
								CurrencyConversionBean.class, uriVariables);
		
		CurrencyConversionBean response = responseEntity.getBody();
		
		return new 
		CurrencyConversionBean(response.getId(),from,to,response.getConversionMultiple(),qty,qty.multiply(response.getConversionMultiple()),response.getPort());*/
	}
}
