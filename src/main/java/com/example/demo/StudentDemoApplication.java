package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class StudentDemoApplication {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
		return args -> {
			studentRepository.createStudent("John", "M");
			studentRepository.createStudent("Agnes", "F");
			studentRepository.createStudent("Tess", "F");

			System.out.println(studentRepository.findStudentByName("ES"));
		};
	}
}
