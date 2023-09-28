package org.pritam.springbootdemo.service;

import java.util.Optional;

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
	
	@Transactional
	public User getUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent())
			return user.get();
		return null;
	}
	
	@Transactional
	public Iterable<User> getAllUsers(){
		return userRepository.findAll();
	}

}
