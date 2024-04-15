package com.devsuperior.uri2602.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2602.dto.CustomerDto;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.entities.CustomerMinProjection;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM customers WHERE state = :state")
	List<CustomerMinProjection> search1(String state);
	
	@Query("SELECT new com.devsuperior.uri2602.dto.CustomerDto(obj.name) FROM Customer obj WHERE obj.state = UPPER(:state)")
	List<CustomerDto> search2(String state);
}
