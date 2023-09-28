package org.pritam.springbootdemo;

import java.util.List;

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
		
		List<User> users = userService.getAllUsersBetweenIdRange(2, 5);
		System.out.println(users);
	}

}
