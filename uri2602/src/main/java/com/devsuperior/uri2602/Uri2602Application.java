package com.devsuperior.uri2602;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2602.dto.CustomerDto;
import com.devsuperior.uri2602.entities.CustomerMinProjection;
import com.devsuperior.uri2602.repository.CustomerRepository;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner{
	
	@Autowired
	private CustomerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<CustomerMinProjection> list = repository.search1("RS");
		List<CustomerDto> result = list.stream().map(x -> new CustomerDto(x)).toList();
		
		System.out.println("*** CONSULTA SQL RAIZ:");
		
		for (CustomerDto obj : result) {
			System.out.println(obj);
		}
		
		System.out.println();
		
		System.out.println("*** CONSULTA JPQL:");
		List<CustomerDto> result2 = repository.search2("rs");
		
		for (CustomerDto obj : result2) {
			System.out.println(obj);
		}
		
	}
}
