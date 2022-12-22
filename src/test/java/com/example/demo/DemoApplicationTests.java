package com.example.demo;

import com.example.demo.composite.ContractRepository;
import com.example.demo.composite.CourseRepository;
import com.example.demo.composite.StudentRepository;
import com.example.demo.composite.model.Contract;
import com.example.demo.composite.model.ContractId;
import com.example.demo.composite.model.Course;
import com.example.demo.composite.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	ContractRepository contractRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	StudentRepository studentRepository;

	@Test
	void simple_test() {
		Course course = new Course();
		course.setName("course");
		course = courseRepository.save(course);

		Student student = new Student();
		student.setName("student");
		student = studentRepository.save(student);

		ContractId contractId = new ContractId();
		contractId.setCourse(course);
		contractId.setStudent(student);

		Contract contract = new Contract();
		contract.setId(contractId);
		contract.setIssued(LocalDateTime.now());
		contractRepository.save(contract);

		assertThat(contractRepository.findAll()).hasSize(1);
	}
}
