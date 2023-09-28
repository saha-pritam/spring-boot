package org.pritam.springbootdemo.restcontroller;

import org.pritam.springbootdemo.entity.User;
import org.pritam.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MyRestController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/getAllUsers")
	public Iterable<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getUser/{id}")
	public User getUser(@PathVariable("id") int id){
		return userService.getUserById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/saveUser")
	public User saveUser(@RequestBody User user){
		return userService.saveUser(user);
	}
}
