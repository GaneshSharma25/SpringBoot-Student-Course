package com.app.services;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.StudentDTO;
import com.app.entites.CourseTitle;
import com.app.exceptions.CustomException;

public interface StudentService {

	List<StudentDTO> getAllStudents();

	ApiResponse addStudent(StudentDTO student) throws CustomException;

	List<StudentDTO> getStudentByCourseName(CourseTitle course) throws CustomException;

}
