package com.tracker.tracker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import junit.framework.Assert;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class UserServiceTest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository userRepository;
	
	private UserService userService;
	
	@Test
	public void createUser() {
		User user = new User();
		user.setFirstName("Praveen");
		user.setLastName("K");
		
		this.userService = new UserService(userRepository);
		
		user = this.userService.createUser(user);
		
		Assert.assertEquals("Praveen", user.getFirstName());
		
	}

}
