package com.app.services;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.CourseDTO;
import com.app.exceptions.CustomException;

public interface CourseService {

	List<CourseDTO> getAllCourse();

	ApiResponse addCourse(CourseDTO course);

	ApiResponse updateCourseFee(long id, double fees)throws CustomException;

	ApiResponse cancelAdmission(long id, long stdId)throws CustomException;

}
