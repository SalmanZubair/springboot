package com.patiently.postgresql.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.patiently.postgresql.model.Members;


@EnableJpaRepositories
public interface MembersRepository extends JpaRepository<Members, Integer> {
	
	@Query(value = "SELECT u FROM Members u")
	List<Members> findAllMembers(Sort sort); 
}
