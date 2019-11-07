package edu.monmouth.hawkscode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.monmouth.hawkscode.domain.User;
import edu.monmouth.hawkscode.domain.UserRepository;

@Component
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void add(User user) {
		userRepository.save(user);
	}
	
	public User getUserById(String id) {
		return userRepository.findById(id);
	}
	
}
