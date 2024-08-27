package com.sam.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.sam.currencyconversionservice")
public class CurrencyConversionServiceAug21Application {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceAug21Application.class, args);
	}

}
