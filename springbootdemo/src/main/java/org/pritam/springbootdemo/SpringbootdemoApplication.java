package org.pritam.springbootdemo;

import org.pritam.springbootdemo.entity.User;
import org.pritam.springbootdemo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootdemoApplication.class, args);
		UserService userService = context.getBean(UserService.class);
		
		userService.deleteAllUsers();
		
	}
}
