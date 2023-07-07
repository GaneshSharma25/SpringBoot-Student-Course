package com.app.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.StudentDTO;
import com.app.entites.Course;
import com.app.entites.Student;
import com.app.exceptions.CustomException;
import com.app.repositories.CourseRepository;
import com.app.repositories.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public List<StudentDTO> getAllStudents() {
		List<Student> studentList = studentRepository.findAll();
		List<StudentDTO> studentDto = new ArrayList<StudentDTO>();
		studentList.forEach((s) -> {
			studentDto.add(mapper.map(s, StudentDTO.class));
		});
		return studentDto;
	}

//	@Override
//	public ApiResponse addStudent(StudentDTO student) throws CustomException {
//		Student std = new Student(student.getFirstName(),student.getLastName(),student.getEmail(),student.getScoreObtained());
//		courseRepo.findByTitle(student.getCourseTitle()).map((course) -> {std.setCourse(course);
//		return studentRepository.save(std);
//		}).orElseThrow(() -> new CustomException("Course Does Not exixts!!"));
//		return new ApiResponse("Student added Successfully");
//	}

	@Override
	public ApiResponse addStudent(StudentDTO student) throws CustomException {

		Course course = courseRepo.findByTitle(student.getCourseTitle())
				.orElseThrow(() -> new CustomException("Course does not exists.."));

		if (student.getScoreObtained() < course.getMinScore()) {
			return new ApiResponse("Score obtained is less than the minimum score required for the course.");
		}
		Student std = new Student(student.getFirstName(), student.getLastName(), student.getEmail(),
				student.getScoreObtained());
		std.setCourse(course);
		studentRepository.save(std);
		return new ApiResponse("Student added successfully!!");
	}

}
