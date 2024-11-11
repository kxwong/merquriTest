package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class StudentRepository {

	@Autowired
	private JdbcTemplate template;

	@PostConstruct
	public void createTable() {
		template.execute(
				"CREATE TABLE student(id bigint auto_increment primary key, name VARCHAR(50), gender VARCHAR(1))");
	}

	public void createStudent(String name, String gender) {
		template.update("INSERT INTO student(name, gender) VALUES (?,?)", name, gender);
	}

	public List<Student> findStudentByName(String name) {
		String sql = "SELECT * FROM student WHERE LOWER(name) LIKE LOWER(?)";
		return template.query(sql, ps -> ps.setString(1, "%" + name + "%"), studentRowMapper());
	}

	private RowMapper<Student> studentRowMapper() {
		return (rs, rowNum) -> new Student(rs.getString("name"), rs.getString("gender"));
	}

}