package com.stream.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name="Video")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Video 
{
	    @Id
	    private  String videoId;

	    private  String title;

	    private  String description;

	    private  String  contentType;

	    private  String filePath;
//	@ManyToOne
//	private Course course;

}
