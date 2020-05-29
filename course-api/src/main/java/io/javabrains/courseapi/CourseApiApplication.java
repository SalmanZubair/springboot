package io.javabrains.courseapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CourseApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(CourseApiApplication.class, args);
	}

}
