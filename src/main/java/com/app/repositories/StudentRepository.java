package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.StudentDTO;
import com.app.entites.Course;
import com.app.entites.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	List<Student> findByCourse(Course course);

}
