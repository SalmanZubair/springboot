package com.patiently.postgresql.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.patiently.postgresql.model.Facilities;


@EnableJpaRepositories
public interface FacilitiesRepository extends JpaRepository<Facilities, Integer> {
	
	@Query(value = "SELECT u FROM Facilities u")
	List<Facilities> findAllFacilities(Sort sort); 
}
