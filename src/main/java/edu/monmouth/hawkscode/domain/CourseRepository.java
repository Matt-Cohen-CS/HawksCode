package edu.monmouth.hawkscode.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
	Course findByNameAndUser(String name, User user);
	Course findByName(String name);
}
