package com.tracker.tracker;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	@CrossOrigin(origins = "http://localhost:4200")
	@Transactional
	public User createUser(@RequestBody User user) {
			
		return this.userService.createUser(user);
		
		
	}
	
	@GetMapping("/list")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
}
