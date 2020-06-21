package com.patiently.postgresql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.patiently.postgresql.model.Bookings;
import com.patiently.postgresql.model.Facilities;
import com.patiently.postgresql.model.Members;
import com.patiently.postgresql.repository.BookingRepository;
import com.patiently.postgresql.repository.FacilitiesRepository;
import com.patiently.postgresql.repository.MembersRepository;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	BookingRepository empr;

	@Autowired
	FacilitiesRepository fac;

	@Autowired
	MembersRepository mem;

	/*@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) throws ResourceNotFoundException {

		Employee employee = empr.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id  :  " + id));

		return ResponseEntity.ok().body(employee);

	}

*/	@RequestMapping(value = "/bookings/all", method = RequestMethod.GET)
	public List<Bookings> getEmployees() {

		System.out.println("Bookings");
		return this.empr.findAll(Sort.by(Sort.Direction.ASC, "bookId"));
	}

	@RequestMapping(value = "/facilities", method = RequestMethod.GET)
	public List<Facilities> getAllFacilities() {

		System.out.println("Facilities");
		return this.fac.findAll(Sort.by(Sort.Direction.ASC, "monthlyMaintenance"));
	}

	@RequestMapping(value = "/members", method = RequestMethod.GET)
	public List<Members> getAllMembers() {

		System.out.println("Members");
		return this.mem.findAllMembers(Sort.by(Sort.Direction.ASC, "joindate"));
	}

	@RequestMapping(value = "/bookings", method = RequestMethod.POST)
	public Bookings createEmployee(@RequestBody Bookings emp) {

		System.out.println("%$#%$^*&(*&(*^(&^*&^^%^%%$^");
		
		Bookings book = new Bookings();
		book.setBookId(emp.getBookId());
		book.setSlots(emp.getSlots());
		book.setStartTime(emp.getStartTime());
		book.setFacility(emp.getFacility());
		book.setMember(emp.getMember());
		
		return this.empr.save(book);

	}
	/*
	@RequestMapping(value = "/employee/fname/{fname}/{lname}", method = RequestMethod.GET)
	public List<Employee> getEmployeeByFirstName(@PathVariable("fname") String fname, @PathVariable String lname)
			throws ResourceNotFoundException {

		List<Employee> employee = empr.findByFirstName(fname, lname);
		if (employee.size() <= 0)
			throw new ResourceNotFoundException("Employee not found for this  name  :  " + fname + " " + lname);

		return employee;

	}
*/
}
