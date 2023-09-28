package org.pritam.springbootdemo.restcontroller;

import org.pritam.springbootdemo.entity.User;
import org.pritam.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllUsers")
	public Iterable<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable("id") int id){
		return userService.getUserById(id);
	}
	
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user){
		return userService.saveUser(user);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user){
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/deleteAllUsers")
	public void deleteAllUsers(){
		userService.deleteAllUsers();
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable("id") int id){
		userService.deleteUserById(id);
	}
}
