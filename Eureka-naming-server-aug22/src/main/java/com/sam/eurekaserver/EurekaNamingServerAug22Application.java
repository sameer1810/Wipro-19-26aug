package com.sam.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer
public class EurekaNamingServerAug22Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaNamingServerAug22Application.class, args);
	}

}
