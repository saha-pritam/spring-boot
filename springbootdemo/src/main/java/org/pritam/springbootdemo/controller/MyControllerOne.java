package org.pritam.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyControllerOne {
	@RequestMapping(value = "/",method = RequestMethod.GET)
	@ResponseBody
	public String welcome() {
		return "This is spring boot demo project";
	}
	
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String home() {
		return "home";
	}
}
