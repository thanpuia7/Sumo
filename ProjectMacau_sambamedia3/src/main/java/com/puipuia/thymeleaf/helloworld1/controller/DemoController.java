package com.puipuia.thymeleaf.helloworld1.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

@RequestMapping("/")
public class DemoController {
	
	// create a mapping for "/hello"

	
	
	@GetMapping("/hello")
	public String sayHello() {
		
		
		
		return "/views/sourcecode";
	}
	
	@GetMapping("/login") 
	public String showLoginForm() {
		
		return "views/Login";  
	}
	
	@GetMapping("/hello1")
	public String sayHello1() {
		
		
		
		return "views/helloworld";
	}
	
	@GetMapping("/electric") 
	public String showElectricForm() {
		
		return "views/ElectricForm";  
	}
	


	
	@GetMapping("/success") 
	public String showPage() {
		
		return "views/success"; 
	
	
}
	
}








