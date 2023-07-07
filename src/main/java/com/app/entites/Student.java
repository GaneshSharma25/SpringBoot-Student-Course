package com.app.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "students")
public class Student extends BaseEntity {
	//first name , last name , email , course title,score obtained.
	@Column(name = "first_name", length = 30)
	private String firstName;
	@Column(name = "last_name", length = 30)
	private String lastName;
	@Column(name = "email", length = 30)
	private String email;
	@ManyToOne()
	@JoinColumn(name = "course_id")
	private Course course;
	private double scoreObtained;
	
	public Student(String firstName, String lastName, String email, double scoreObtained) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.scoreObtained = scoreObtained;
	}
}
