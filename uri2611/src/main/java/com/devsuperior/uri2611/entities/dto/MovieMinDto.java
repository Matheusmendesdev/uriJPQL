package com.devsuperior.uri2611.entities.dto;

import com.devsuperior.uri2611.entities.MovieMinProjection;

public class MovieMinDto {
	private Long id;
	private String name;
	
	public MovieMinDto() {}

	public MovieMinDto(Long id, String name) { 
		this.id = id;
		this.name = name;
	}
	
	public MovieMinDto(MovieMinProjection movies) {
		id = movies.getId();
		name = movies.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MovieMinDto [id=" + id + ", name=" + name + "]";
	}
	
	
}
