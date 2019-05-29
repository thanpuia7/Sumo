package com.puipuia.thymeleaf.helloworld1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.puipuia.thymeleaf.helloworld1.Repositories.RoleRepository;
import com.puipuia.thymeleaf.helloworld1.Repositories.UserRepository;


@Controller

@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserRepository userRepository;

	


	
	public AdminController(UserRepository userRepository, RoleRepository roleRepository) {
	
		this.userRepository = userRepository;
	
	}




	@GetMapping("/profile")
		
		public String AdminProfile(Model theModel,@RequestParam(defaultValue="0") int page ) {
			
		
			theModel.addAttribute("users", userRepository.findAll(PageRequest.of(page, 4)));
		
	 
			theModel.addAttribute("currentPage", page);
			
		
		return "views/admin-profile";
		
		
	}

}
