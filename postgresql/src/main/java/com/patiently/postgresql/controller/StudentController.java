package com.patiently.postgresql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.patiently.postgresql.model.Course;
import com.patiently.postgresql.model.Student;
import com.patiently.postgresql.repository.CourseRepository;
import com.patiently.postgresql.repository.MembersRepository;
import com.patiently.postgresql.repository.StudentRepository;

@RestController
@RequestMapping("/")
public class StudentController {

	@Autowired
	CourseRepository course;

	@Autowired
	StudentRepository student;

	@Autowired
	MembersRepository mem;

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public List<Student> getStudents() {

		System.out.println("Students");
		return this.student.findAll(Sort.by(Sort.Direction.ASC, "age"));
	}

	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public List<Course> getAllCourses() {

		System.out.println("Courses");
		return this.course.findAll(Sort.by(Sort.Direction.ASC, "fee"));
	}

	@RequestMapping(value = "/courses", method = RequestMethod.POST)
	public Course createCourses(@RequestBody Course cour) {

		System.out.println("Adding Course");
		return this.course.save(cour);

	}
	
	@RequestMapping(value = "/students/{courseId}", method = RequestMethod.POST)
	public Student createStudents(@RequestBody Student st, @PathVariable long courseId) {

		System.out.println("Adding Student");
		Student stNew = this.student.findById(st.getId()).get();
		
		stNew.getCourses().add(course.findById(courseId));
		return this.student.save(stNew);

	}

}
