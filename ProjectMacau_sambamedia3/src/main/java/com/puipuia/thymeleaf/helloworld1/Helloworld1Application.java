package com.puipuia.thymeleaf.helloworld1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.puipuia.thymeleaf.helloworld1.Services.UserService;
import com.puipuia.thymeleaf.helloworld1.entities.User;



@SpringBootApplication
public class Helloworld1Application implements CommandLineRunner{

		@Autowired
	   private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(Helloworld1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		  {
    		  User newAdmin = new User("admin@gmail.com", "Admin", "123456");
    		  userService.createAdmin(newAdmin); 
    	  }
	}
}

