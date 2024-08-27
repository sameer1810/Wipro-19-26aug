package com.sam.reactivemono;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@SpringBootApplication
public class SpringReactiveMono23augApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveMono23augApplication.class, args);
		
Mono<String> myMonoString = Mono.just("This is my first Mono variable");
	    
	    myMonoString.subscribe(
	    		System.out::println);
	    
		
		String[] cities = new String[] {"Delhi","Bhopal","Chennai","Mumbai","Hyderabad"};
		
		Flux<String> myFluxCities = Flux.fromArray(cities)
	    		.delayElements(Duration.ofSeconds(1))
	    		.subscribeOn(Schedulers.boundedElastic());
	    
	    myFluxCities.subscribe(
	         System.out::println);
	    
        myFluxCities
	    .filter(city -> city.length() > 4)
        .map(String::toUpperCase)
	    .subscribe(System.out::println);
	}

}
