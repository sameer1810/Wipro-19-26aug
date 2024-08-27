package com.sam.reactive;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.sam.reactive.model.Student;
import com.sam.reactive.service.StudentHandler;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class SpringReactiveMongo24augApplicationTests {

	@Autowired
	private WebTestClient webTestClient;
	
	@MockBean
	private StudentHandler studentHandler;
	
	@Test
	void testAddStudent() {
		
		Student student = new Student();
		student.setName("Radhika");
		student.setAge(26);

		Student student1 = new Student();
		student.setName("Rajesh");
		student.setAge(28);
		
		when(studentHandler.addStudent(any())).thenReturn(ServerResponse.ok().bodyValue(student));
		
		webTestClient.post().uri("/api/student/add").contentType(MediaType.APPLICATION_JSON)
			.bodyValue(student)
			.equals(student1);
	}
	
	@Test
	void testUpdateStudentById() {
		
		Student student = new Student();
		student.setName("Mahi");
		student.setAge(22);
		
		when(studentHandler.updateStudentById(any())).thenReturn(ServerResponse.ok().bodyValue(student));
		
		webTestClient.post().uri("/api/student/update").contentType(MediaType.APPLICATION_JSON)
			.bodyValue(student)
			.equals(student);
	}


}
