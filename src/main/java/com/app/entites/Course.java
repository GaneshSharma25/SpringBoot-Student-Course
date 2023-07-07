package com.app.entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "courses")
public class Course extends BaseEntity {
		//eg : course title(unique) , start date , end date , fees , min score
	@Enumerated(EnumType.STRING)
	private CourseTitle title;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "end_date")
	private LocalDate endDate;
	private double fees;
	private double minScore;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "course",orphanRemoval = true )
	private List<Student> students = new ArrayList<Student>();
	
	public Course(CourseTitle title, LocalDate startDate, LocalDate endDate, double fees, double minScore) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fees = fees;
		this.minScore = minScore;
	}
	
}
