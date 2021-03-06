package com.tracker.tracker;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserService {

	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Transactional
	public User createUser(User user) {
		return this.userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return this.userRepository.findAll();
	}
}
