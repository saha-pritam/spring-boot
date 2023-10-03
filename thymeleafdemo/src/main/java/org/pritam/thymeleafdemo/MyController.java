package org.pritam.thymeleafdemo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	@GetMapping("/")
	public String home(Model model) {
		String name1 = "Pritam";
		String name2 = "Soumi";
		String name3 = "Sourav";
		model.addAttribute("name1", name1);
		model.addAttribute("name2", name2);
		model.addAttribute("name3", name3);
		return "home";
	}
}
