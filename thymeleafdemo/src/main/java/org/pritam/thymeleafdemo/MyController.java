package org.pritam.thymeleafdemo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	@GetMapping("/")
	public String home(Model model) {
		List<String> l = List.of("Pritam","Aditya","Gunjan","Agniva","Shitij","Nilesh");
		model.addAttribute("list", l);
		return "home";
	}
}
