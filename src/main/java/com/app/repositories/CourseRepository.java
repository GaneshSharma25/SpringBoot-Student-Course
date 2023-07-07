package com.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entites.Course;
import com.app.entites.CourseTitle;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	Optional<Course> findByTitle(CourseTitle title);

}
