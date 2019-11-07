package edu.monmouth.hawkscode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.monmouth.hawkscode.domain.Challenge;
import edu.monmouth.hawkscode.domain.ChallengeRepository;
import edu.monmouth.hawkscode.domain.Course;

@Component
public class ChallengeService {

	@Autowired
	private ChallengeRepository challengeRepository;
	
	public void add(Challenge challenge) {
		challengeRepository.save(challenge);
	}
	
	public List<Challenge> getByCourse(Course course) {
		return challengeRepository.findByCourse(course);
	}
	
	public Challenge getByNameAndCourse(String name, Course course) {
		return challengeRepository.findByNameAndCourse(name, course);
	}
	
	public Challenge getByNameAndCourseAndIsCompleted(String name, Course course, boolean isCompleted) {
		return challengeRepository.findByNameAndCourseAndIsCompleted(name, course, isCompleted);
	}
}
