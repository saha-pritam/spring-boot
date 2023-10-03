package org.pritam.thymeleafdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "Hi my name is pritam");
		return "home";
	}
}
