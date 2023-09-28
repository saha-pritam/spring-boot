package org.pritam.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v2")
@ResponseBody
public class MyControllerTwo {
	@RequestMapping(value = "/one",method = RequestMethod.GET)
	public String one() {
		return "This is method one from MyControllerTwo";
	}
	
	@RequestMapping(value = "/two",method = RequestMethod.GET)
	public String two() {
		return "This is method two from MyControllerTwo";
	}
}
