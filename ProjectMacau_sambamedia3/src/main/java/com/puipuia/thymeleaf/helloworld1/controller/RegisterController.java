package com.puipuia.thymeleaf.helloworld1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.puipuia.thymeleaf.helloworld1.Services.UserService;
import com.puipuia.thymeleaf.helloworld1.entities.User;


@Controller
public class RegisterController {
	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String registerForm(Model model) {

		model.addAttribute("user", new User());
		return "views/Register";
	}
	
	
	@PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "views/Register";
		}
		if(userService.isUserPresent(user.getEmail())) {
			model.addAttribute("exist",true);

			return "views/Register";

		}
		
	
		userService.createUser(user);
		
		return "index";

	}

}


