package com.sam.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.sam.reactive.service.StudentHandler;

@Configuration
public class StudentRouter {

	@Autowired
	private StudentHandler studentHandler;
	
	@Bean
	RouterFunction<ServerResponse> routerFunction() {
		return RouterFunctions.route(RequestPredicates.POST("api/student/add"),studentHandler::addStudent)
				.andRoute(RequestPredicates.POST("api/student/update"), studentHandler::updateStudentById)
				.andRoute(RequestPredicates.POST("api/student/delete"), studentHandler::deleteStudentById)
				.andRoute(RequestPredicates.GET("api/student/getall"), studentHandler::getAllStudents);
		
	}
}
