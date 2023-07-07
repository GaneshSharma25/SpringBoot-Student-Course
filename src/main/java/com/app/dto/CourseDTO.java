package com.app.dto;

import java.time.LocalDate;

import com.app.entites.CourseTitle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseDTO {

	// eg : course title(unique) , start date , end date , fees , min score

	private CourseTitle title;
	private LocalDate startDate;
	private LocalDate endDate;
	private double fees;
	private double minScore;

}
