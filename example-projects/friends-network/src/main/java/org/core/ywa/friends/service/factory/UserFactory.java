package org.core.ywa.friends.service.factory;

import java.util.ArrayList;

import org.core.ywa.friends.entity.User;
import org.core.ywa.friends.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserFactory {

	@Autowired
	private UserRepo repo;
	
	@Transactional
	public void initUsers() {
		var users = new ArrayList<User>();
		for(int i = 0; i < 5; i ++) {
			var user = new User();
			user.setName("user%s".formatted(i + 1));
			user.setEmail("user%s@gmail.com".formatted(i + 1));
			user.setPassword("password");
			users.add(user);
		}
		repo.saveAll(users);
	}
}
