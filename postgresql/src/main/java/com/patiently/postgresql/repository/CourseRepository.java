package com.patiently.postgresql.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.patiently.postgresql.model.Course;

@EnableJpaRepositories
public interface CourseRepository extends JpaRepository<Course, Long> {

	List<Course> findAll(Sort sort);
	
	Course findById(long id);

}
