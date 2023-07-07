package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.CourseDTO;
import com.app.exceptions.CustomException;
import com.app.services.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@GetMapping
	public List<CourseDTO> getAllCourse(){
		return courseService.getAllCourse();
	}
	
	@PostMapping("/add")
	public ApiResponse addCourse(@RequestBody CourseDTO course) {
		
		return courseService.addCourse(course);
		
	}
	
	@PutMapping("/{id}/fees/{fees}")
	public ApiResponse updateCourseFee(@PathVariable long id,@PathVariable double fees) throws CustomException {
		return courseService.updateCourseFee(id,fees);
	}
    
	@DeleteMapping("/{id}/student/{stdId}")
	public ApiResponse cancelAdmission(@PathVariable long id, @PathVariable long stdId)throws CustomException {
		return courseService.cancelAdmission(id,stdId);
	}

}
