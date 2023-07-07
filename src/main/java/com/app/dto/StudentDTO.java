package com.app.dto;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.app.entites.CourseTitle;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class StudentDTO {
	@JsonProperty(access = Access.READ_ONLY)
	private long id;
	@NotBlank(message = "First Name can't be blank!!")
	private String firstName;
	private String lastName;
	@Email
	private String email;
	private double scoreObtained;
	private CourseTitle courseTitle;
}

