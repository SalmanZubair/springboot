package com.patiently.postgresql.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.patiently.postgresql.model.Student;

@EnableJpaRepositories
public interface StudentRepository extends CrudRepository<Student, Long> {

	List<Student> findAll(Sort sort);

}
