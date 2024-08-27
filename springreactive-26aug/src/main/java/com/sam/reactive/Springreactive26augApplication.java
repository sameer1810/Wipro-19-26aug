package com.sam.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class Springreactive26augApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springreactive26augApplication.class, args);
		
Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        
        Flux.fromArray(numbers)
            .subscribe(System.out::println);  
        
        Flux.fromArray(numbers) 
            .reduce(Integer::sum)  
            .subscribe(sum ->
            System.out.println("Sum: " + sum));
        
         Mono<String> myMonoString = Mono.just("I Love Photography");

         myMonoString.subscribe(
             System.out::println,  
             error -> System.err.println("Error: " + error),  
             () -> System.out.println("Nature"));
	}

}
