package org.pritam.springbootdemo.restcontroller;

import java.util.Collection;

import org.pritam.springbootdemo.model.Error;
import org.pritam.springbootdemo.entity.User;
import org.pritam.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Object> getAllUsers(){
		Iterable<User> allUsers = userService.getAllUsers();
		if(allUsers==null || ((Collection<?>)allUsers).size()==0) {
			Error error = new Error();
			error.setErrorCode(404);
			error.setDescription("There are no users in the database");
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(allUsers,HttpStatus.OK);	
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<Object> getUser(@PathVariable("id") int id){
		User user = userService.getUserById(id);
		if(user==null) {
			Error error = new Error();
			error.setErrorCode(404);
			error.setDescription("User not found in database");
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user,HttpStatus.OK);
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
	public ResponseEntity<Object> deleteAllUsers(){
		userService.deleteAllUsers();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("id") int id){
		userService.deleteUserById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
