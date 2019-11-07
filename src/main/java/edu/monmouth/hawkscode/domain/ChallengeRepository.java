package edu.monmouth.hawkscode.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRepository extends CrudRepository<Challenge, Long> {

	List<Challenge> findByCourse(Course course); 
	Challenge findByNameAndCourse(String name, Course course);
	Challenge findByNameAndCourseAndIsCompleted(String name, Course course, boolean isCompleted);
}
