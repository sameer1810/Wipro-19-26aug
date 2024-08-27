package com.sam.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.sam.reactive.model.Student;
import com.sam.reactive.repository.StudentRepository;

import reactor.core.publisher.Mono;

@Service
public class StudentHandler {

	@Autowired
	private StudentRepository studentRepo;
	
	public Mono<ServerResponse> addStudent(ServerRequest request) {
		return request.bodyToMono(Student.class).flatMap(data -> {
					return ServerResponse.ok().body(studentRepo.save(data), Student.class);
				});
		
	}

	public Mono<ServerResponse> updateStudentById(ServerRequest request) {
		return request.bodyToMono(Student.class).flatMap(data -> {
			return studentRepo.findById(data.getId()).flatMap(change -> {
			        change.setId(data.getId());
			        change.setName(data.getName());
			        change.setAge(data.getAge());
			        return ServerResponse.ok().body(studentRepo.save(change), Student.class);
		}).switchIfEmpty(ServerResponse.ok().bodyValue("No Student Data Found"));
	});
  }
	
	public Mono<ServerResponse> deleteStudentById(ServerRequest request) {
		return request.bodyToMono(Student.class).flatMap(data -> {
			return ServerResponse.ok().body(studentRepo.deleteById(data.getId()), Student.class);
		}).switchIfEmpty(ServerResponse.ok().bodyValue("No Student Data Found"));
		
	}
	
	public Mono<ServerResponse> getAllStudents(ServerRequest request) {
		return request.bodyToMono(Student.class).flatMap(data -> {
			return ServerResponse.ok().body(studentRepo.findAll(), Student.class);
		}).switchIfEmpty(ServerResponse.ok().bodyValue("No Student Data Found"));
		
	}
}
