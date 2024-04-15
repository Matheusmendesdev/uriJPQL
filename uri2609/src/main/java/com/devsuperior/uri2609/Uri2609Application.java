package com.devsuperior.uri2609;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import com.devsuperior.uri2609.repositories.CategoryRepository;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<CategorySumProjection> list = repository.search();
		List<CategorySumDTO> result = list.stream().map(x -> new CategorySumDTO(x)).toList();
		
		System.out.println("*** CONSULTA SQL RAIZ: ");
		
		for (CategorySumDTO obj : result) {
			System.out.println(obj);
		}
		
		List<CategorySumDTO> result2 = repository.search2();
		
		System.out.println("*** CONSULTA JPQL: ");
		
		for (CategorySumDTO obj : result2) {
			System.out.println(obj);
		}
	}
}
