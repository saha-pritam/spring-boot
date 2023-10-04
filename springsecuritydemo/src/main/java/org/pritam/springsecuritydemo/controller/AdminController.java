package org.pritam.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AdminController {
	@GetMapping("/admin")
	public String welcome() {
		return "This is the admin welcome page.";
	}
}
