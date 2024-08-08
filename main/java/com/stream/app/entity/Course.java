package com.stream.app.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Table(name="course")
@Entity
public class Course
{
	     @Id
	    private  String id;

	    private  String title;

	
//	@OneToMany(mappedBy="Course")
//	private List<Video> list=new ArrayList<>(); 

}
