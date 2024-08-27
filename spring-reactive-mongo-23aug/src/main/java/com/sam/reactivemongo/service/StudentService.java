package com.sam.reactivemongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.reactivemongo.model.Student;
import com.sam.reactivemongo.repository.StudentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Mono<Student> addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Flux<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Mono<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public Mono<Void> deleteStudent(String id) {
        return studentRepository.deleteById(id);
    }

    public Mono<Student> getStudentsByName(String name) {
        return studentRepository.findById(name); 
    }
}
