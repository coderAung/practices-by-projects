package org.core.ywa.friends.service;

import org.core.ywa.friends.dto.LoginUser;
import org.core.ywa.friends.dto.input.LoginForm;
import org.core.ywa.friends.repo.UserRepo;
import org.core.ywa.friends.util.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;

	public LoginUser login(LoginForm form) {
		return repo.findByEmailAndPassword(form.getEmail(), form.getPassword())
				.map(LoginUser::from).orElseThrow(() -> new ApplicationException("Email or Password is incorrect!"));
	}

}
