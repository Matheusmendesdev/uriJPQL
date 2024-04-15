package com.devsuperior.uri2611;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2611.entities.MovieMinProjection;
import com.devsuperior.uri2611.entities.dto.MovieMinDto;
import com.devsuperior.uri2611.repository.MovieRepository;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner{
	
	@Autowired
	private MovieRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<MovieMinProjection> list = repository.search1("Action");
		List<MovieMinDto> result = list.stream().map(x -> new MovieMinDto(x)).toList();
		
		System.out.println("*** CONSULTA SQL RAIZ MOVIE: ");
		
		for (MovieMinDto obj : result) {
			System.out.println(obj);
		}
		
		System.out.println("*** CONSULTA JPQL MOVIE: ");
		
		List<MovieMinDto> result2 = repository.search2("Action");
		
		for (MovieMinDto obj : result2) {
			System.out.println(obj);
		}
	}
}
