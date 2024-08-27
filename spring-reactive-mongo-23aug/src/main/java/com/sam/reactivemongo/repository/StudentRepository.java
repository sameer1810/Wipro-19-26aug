package com.sam.reactivemongo.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.stereotype.Repository;

import com.sam.reactivemongo.model.Student;

@Repository
@EnableReactiveMongoRepositories
public interface StudentRepository extends ReactiveMongoRepository<Student, String> {

}
