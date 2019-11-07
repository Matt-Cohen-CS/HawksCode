package edu.monmouth.hawkscode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.monmouth.hawkscode.domain.Course;
import edu.monmouth.hawkscode.domain.CourseRepository;
import edu.monmouth.hawkscode.domain.User;

@Component
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public void add(Course course) {
		courseRepository.save(course);
	}
	
	public Course getByNameAndUser(String courseName, User user) {
		return courseRepository.findByNameAndUser(courseName, user);
	}
	
	
}
