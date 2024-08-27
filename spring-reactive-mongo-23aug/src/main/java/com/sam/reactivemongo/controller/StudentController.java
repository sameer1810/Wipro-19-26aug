package com.sam.reactivemongo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.sam.reactivemongo.model.Student;
import com.sam.reactivemongo.service.StudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    public StudentService studentService;

    @GetMapping(value = "students", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("student/{id}")
    public Mono<Student> getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Mono<Student> createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteStudent(@PathVariable String id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("name/{name}")
    public Mono<Student> getStudentsByName(@PathVariable String name) {
        return studentService.getStudentById(name);
    }
}
