package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.CourseDTO;
import com.app.entites.Course;
import com.app.entites.Student;
import com.app.exceptions.CustomException;
import com.app.repositories.CourseRepository;
import com.app.repositories.StudentRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	StudentRepository studentRepo;

	@Override
	public List<CourseDTO> getAllCourse() {
		List<Course> course = courseRepo.findAll();
		List<CourseDTO> courseDto = new ArrayList<CourseDTO>();
		course.forEach((c) -> {courseDto.add(mapper.map(c, CourseDTO.class));});
		return courseDto;
	}

	@Override
	public ApiResponse addCourse(CourseDTO course) {
		//CourseTitle title, LocalDate startDate, LocalDate endDate, double fees, double minScore
		//	Course c = new Course(course.getTitle(),course.getStartDate(),course.getEndDate(),course.getFees(),course.getMinScore());
			courseRepo.save(mapper.map(course, Course.class));
		return new ApiResponse("Course Added Successfully!!");
	}

	@Override
	public ApiResponse updateCourseFee(long id, double fees) throws CustomException {
		Course course = courseRepo.findById(id).orElseThrow(() -> new CustomException("Course not found!!"));
		course.setFees(fees);
		courseRepo.save(course);
		return new ApiResponse("Course Fees updated successfully!!");
	}

	@Override
	public ApiResponse cancelAdmission(long id, long stdId) throws CustomException {
		
		String message= "Invalid Student ID..";
		
		if(studentRepo.existsById(stdId)) {
		    Student student = studentRepo.findById(stdId).orElseThrow(() -> new CustomException("Invalid Student ID.."));
		    if(student.getCourse().getId() == id) {
		    	studentRepo.deleteById(stdId);
		    	message = "student Admission cancelled successfully!!";
		    }else {
		    	message = "invalid Course ID..";
		    }
		}
		return new ApiResponse(message);
	}

}
