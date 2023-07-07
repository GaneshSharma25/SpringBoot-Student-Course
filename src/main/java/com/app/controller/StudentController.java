package com.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.StudentDTO;
import com.app.exceptions.CustomException;
import com.app.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	public StudentService studentService;

	@GetMapping
	public ResponseEntity<?> getAllStudent() {
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.getAllStudents());
	}

	@PostMapping("/add")
	public ApiResponse addStudent(@RequestBody StudentDTO student) throws CustomException {

		return studentService.addStudent(student);

	}
}
