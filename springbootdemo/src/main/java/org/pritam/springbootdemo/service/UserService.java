package org.pritam.springbootdemo.service;

import java.util.List;
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
	
	@Transactional
	public User updateUser(User user) {
		return saveUser(user);
	}
	
	@Transactional
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}
	
	@Transactional
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}
	
	@Transactional
	public List<User> getUsersByLastName(String lastName){
		return userRepository.findByLastName(lastName);
	}

}
