package com.devsuperior.uri2602.dto;

import com.devsuperior.uri2602.entities.CustomerMinProjection;

public class CustomerDto {
	
	private String name;
	
	public CustomerDto() {}
	
	public CustomerDto(String name) {
		this.name = name;
	}
	
	public CustomerDto(CustomerMinProjection project) {
		name = project.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CustomerDto [name=" + name + "]";
	}
	
	
}
