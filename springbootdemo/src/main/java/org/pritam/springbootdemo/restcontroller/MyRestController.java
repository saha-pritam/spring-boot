package org.pritam.springbootdemo.restcontroller;

import java.util.Collection;

import org.pritam.springbootdemo.model.Error;
import org.pritam.springbootdemo.entity.User;
import org.pritam.springbootdemo.service.AddressService;
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
	@Autowired
	private AddressService addressService; 
	
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
	public ResponseEntity<Object> saveUser(@RequestBody User user){
		if(user.getId()!=0 || user.getAddress().getId()!=0) {
			Error error = new Error();
			error.setDescription("Please don't pass userid or addressid attribute in the JSON body.");
			error.setErrorCode(400);
			return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		}
		user = userService.saveUser(user);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<Object> updateUser(@RequestBody User user){
		if(user.getId()==0 || user.getAddress().getId()==0) {
			Error error = new Error();
			error.setDescription("Please make sure that user id and address id are mentioned in JSON body with proper value.");
			error.setErrorCode(400);
			return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		}
		if(userService.isIdAvailable(user.getId())) {
			int addressId = addressService.getAddressId(user.getId());
			if(addressId==0 || addressId!=user.getAddress().getId()) {
				Error error = new Error();
				error.setDescription("Provided address id is not associated with given user id.");
				error.setErrorCode(404);
				return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
			}
		}
		else {
			Error error = new Error();
			error.setDescription("Provided user id is not available.");
			error.setErrorCode(404);
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		}
		user = userService.updateUser(user);
		return new ResponseEntity<>(user,HttpStatus.OK);
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
