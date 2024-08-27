package com.sam.reactive;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class WebFluxExampleAug24Application {

	public static void main(String[] args) {
		SpringApplication.run(WebFluxExampleAug24Application.class, args);
		
		Mono<Integer> monoInt = Mono.just(12) ;
		  
	    monoInt.subscribe(System.out::println);
	    
	    System.out.println("\nFlux..........");
	    
	    Flux<Integer> fluxInt = Flux.just(1,2,3,4,5,6,7,8,9)
	    		.delayElements(Duration.ofSeconds(2));
	    
	    fluxInt.subscribe(System.out::println);
	    
	    fluxInt.blockLast();
	}

}
