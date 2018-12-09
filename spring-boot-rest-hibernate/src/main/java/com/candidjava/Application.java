package com.candidjava;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.candidjava.spring.bean.User;
import com.candidjava.spring.service.UserService;
@SpringBootApplication
public class Application implements CommandLineRunner {
	
	
	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<User> userList = new ArrayList<User>();
		User user = new User();
		user.setCountry("ind");
		user.setName("suri");
		userList.add(user);
		User user1 = new User();
		user1.setCountry("ind");
		user1.setName("muni");
		userList.add(user1);
		User user2 = new User();
		user2.setCountry("ind");
		user2.setName("suri");
		userList.add(user2);
		userService.createUserList(userList);
		System.out.println("completed");
	}

}
