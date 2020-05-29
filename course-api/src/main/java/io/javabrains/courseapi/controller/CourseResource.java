package io.javabrains.courseapi.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseResource {

	@RequestMapping("/{courseId}")
	public String getRating(@PathVariable("courseId") String courseId) {
		return courseId;
	}

}