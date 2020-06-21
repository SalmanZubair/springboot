package com.patiently.postgresql.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.patiently.postgresql.model.Bookings;

@EnableJpaRepositories
public interface BookingRepository extends JpaRepository<Bookings, Long> {

	@Query(value = "SELECT u FROM Bookings u")
	List<Bookings> findAllEmployee(Sort sort);

}
