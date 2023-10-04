package org.pritam.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {
	@GetMapping("/user")
	public String welcome() {
		return "This is the user welcome page.";
	}
}
