package com.sam.exchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyExchangeServiceAug21Application {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceAug21Application.class, args);
	}

}
