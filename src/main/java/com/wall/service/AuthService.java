package com.wall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wall.dao.UserRepository;
import com.wall.entities.User;

@Component
public class AuthService {

	@Autowired
	UserRepository userRepository;
	
	public User authenticate(String login, String password) {
		User user = null;
		try {
			
			 user = userRepository.findByLoginAndPassword(login,password);

		} catch (Exception e) {
			System.out.println("An error occured when authenticating "+ e.getMessage());
		}

		return user;

	}

}