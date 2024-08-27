package com.sam.springbootAOP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SpringbootAop26augApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAop26augApplication.class, args);
	}

}
