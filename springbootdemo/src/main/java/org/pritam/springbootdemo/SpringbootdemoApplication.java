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
		
		User user1 = new User("Pritam","Saha");
		User user2 = new User("Soumi","Saha");
		User user3 = new User("Aditya","Ghosh");
		User user4 = new User("Agniva","Paul");
		User user5 = new User("Nilesh","Roy");
		User user6 = new User("Shitij","Bhadra");
		User user7 = new User("Agradip","Banik");
		User user8 = new User("Sourav","Raha");
		
		userService.saveUser(user1);
		userService.saveUser(user2);
		userService.saveUser(user3);
		userService.saveUser(user4);
		userService.saveUser(user5);
		userService.saveUser(user6);
		userService.saveUser(user7);
		userService.saveUser(user8);
	}

}
