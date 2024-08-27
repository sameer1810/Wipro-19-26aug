package com.sam.reactive.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sam.reactive.model.Student;

public interface StudentRepository extends ReactiveMongoRepository<Student, String> {

}
