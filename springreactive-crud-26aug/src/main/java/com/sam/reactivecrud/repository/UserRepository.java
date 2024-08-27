package com.sam.reactivecrud.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sam.reactivecrud.model.User;

public interface UserRepository extends ReactiveMongoRepository<User, String> {

}