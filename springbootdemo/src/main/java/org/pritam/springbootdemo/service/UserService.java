package org.pritam.springbootdemo.service;

import org.pritam.springbootdemo.entity.User;
import org.pritam.springbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User saveUser(User user) {
		return userRepository.save(user);
	}

}
