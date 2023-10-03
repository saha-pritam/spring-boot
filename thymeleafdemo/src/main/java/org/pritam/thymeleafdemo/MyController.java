package org.pritam.thymeleafdemo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	@GetMapping("/")
	public String home(Model model) {
		int caseVal=10;
		model.addAttribute("caseVal", caseVal);
		return "home";
	}
}
