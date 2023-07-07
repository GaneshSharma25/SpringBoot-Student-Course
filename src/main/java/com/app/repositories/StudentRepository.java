package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entites.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
