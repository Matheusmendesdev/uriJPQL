package com.devsuperior.uri2611.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.entities.MovieMinProjection;
import com.devsuperior.uri2611.entities.dto.MovieMinDto;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	@Query(nativeQuery = true, value = "SELECT movies.id, movies.name "
			+ "FROM movies "
			+ "INNER JOIN genres ON genres.id = movies.id_genres "
			+ "WHERE genres.description = :genres")
	List<MovieMinProjection> search1(String genres);
	
	@Query("SELECT new com.devsuperior.uri2611.entities.dto.MovieMinDto(obj.id, obj.name) "
			+ "FROM Movie obj "
			+ "WHERE obj.genre.description = :genres")
	List<MovieMinDto> search2(String genres);
}
