package com.puipuia.thymeleaf.helloworld1.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.puipuia.thymeleaf.helloworld1.Repositories.BookingRepository;
import com.puipuia.thymeleaf.helloworld1.Repositories.DistrictRepository;
import com.puipuia.thymeleaf.helloworld1.Repositories.SumoRepository;
import com.puipuia.thymeleaf.helloworld1.Services.SumoServices;
import com.puipuia.thymeleaf.helloworld1.entities.Booking;
import com.puipuia.thymeleaf.helloworld1.entities.Sumo;


@Controller

@RequestMapping("/")
public class SumoController {
	
	@Autowired
	SumoRepository sumoRepository;
	@Autowired
	SumoServices sumoServices;
	@Autowired
	DistrictRepository districtRepository;
	@Autowired
	BookingRepository bookingRepository;
	
	
	@Autowired
	SumoController(SumoRepository sumoRepository, DistrictRepository districtRepository, BookingRepository bookingRepository){
		this.sumoRepository=sumoRepository;
		this.districtRepository=districtRepository;
		this.bookingRepository=bookingRepository;
	}
	
	Sumo theSumo = new Sumo();
	Booking theBooking=new Booking();
	List<Sumo>sumo1;
	
	@GetMapping("/sumo") 
	public String showSumoForm(Model model) {

		  
		
			model.addAttribute("sumo", theSumo);
			model.addAttribute("districts",districtRepository.findAll());
	
		return "views/SumoForm";  
	}
	
	
	@PostMapping("/sumoSearch")
	public String searchSumo(@ModelAttribute("sumo")  Sumo theSumo, Model model) {
		
		
		
		model.addAttribute("booking",this.theBooking);
		 
		 model.addAttribute("sumo", theSumo);
		 
		
		
		if(theSumo.getFrom().equals(theSumo.getTo()))
		{
			model.addAttribute("title","Please select Different Destination");
			
			
			
			
			
			
	
		return "views/SumoForm";  
			
			
		}

	
		
	if((theSumo.getFrom().equals("AIZAWL")&&theSumo.getTo().equals("LUNGLEI")) || (theSumo.getFrom().equals("LUNGLEI")&& theSumo.getTo().equals("AIZAWL")))
		theSumo.setRate("1");
		
	
	if((theSumo.getFrom().equals("AIZAWL")&&theSumo.getTo().equals("CHAMPHAI")) || (theSumo.getFrom().equals("CHAMPHAI")&& theSumo.getTo().equals("AIZAWL")))
		theSumo.setRate("2");
	
	if((theSumo.getFrom().equals("AIZAWL")&&theSumo.getTo().equals("KOLASIB")) || (theSumo.getFrom().equals("KOLASIB")&& theSumo.getTo().equals("AIZAWL")))
		theSumo.setRate("3");
	
	if((theSumo.getFrom().equals("LUNGLEI")&&theSumo.getTo().equals("CHAMPHAI")) || (theSumo.getFrom().equals("CHAMPHAI")&& theSumo.getTo().equals("LUNGLEI")))
		theSumo.setRate("4");
	
	if((theSumo.getFrom().equals("LUNGLEI")&&theSumo.getTo().equals("KOLASIB")) || (theSumo.getFrom().equals("KOLASIB")&& theSumo.getTo().equals("LUNGLEI")))
		theSumo.setRate("5");
	
	
	if((theSumo.getFrom().equals("CHAMPHAI")&&theSumo.getTo().equals("KOLASIB")) || (theSumo.getFrom().equals("KOLASIB")&& theSumo.getTo().equals("CHAMPHAI")))
		theSumo.setRate("6");
	
	

	
	  
	
	
  List <Sumo> sumo1=(sumoServices.findByFromToDate(theSumo.getFrom(),theSumo.getTo(),theSumo.getDate()));
		

		 
		 
		if(sumo1.isEmpty())
  
  

	    		
	    		{
	    	
			
			
			theSumo.setVacancy(8);
			theSumo.setSeat1("A");
			theSumo.setSeat2("A");
			theSumo.setSeat3("A");
			theSumo.setSeat4("A");
			theSumo.setSeat5("A");
			theSumo.setSeat6("A");
			theSumo.setSeat7("A");
			theSumo.setSeat8("A");
			
		
	
	   model.addAttribute("things", theSumo);
			 
	
	   
	   this.theSumo=theSumo;
	   
	 
	   
	   return "views/SumoBookingForm";
	    	

	    
	    }
		 
							for (Sumo sumo2 : sumo1)
									{
								
								
								
										if(sumo2.getVacancy().equals(0))
												{
				 
													model.addAttribute("Ruak","Seat Full - Select other date ");
				 
															return "views/SumoForm";
				 
												}
										
										
										
										theSumo=sumo2;
								/*		theSumo.setId(sumo2.getId());
										theSumo.setVacancy(sumo2.getVacancy());
										theSumo.setSeat1(sumo2.getSeat1());
										theSumo.setSeat2(sumo2.getSeat2());
										theSumo.setSeat3(sumo2.getSeat3());
										theSumo.setSeat4(sumo2.getSeat4());
										theSumo.setSeat5(sumo2.getSeat5());
										theSumo.setSeat6(sumo2.getSeat6());
										theSumo.setSeat7(sumo2.getSeat7());
										theSumo.setSeat8(sumo2.getSeat8());
									*/	
		 
									}	 
							
								

 				
								
		this.theSumo=theSumo;
	
	this.sumo1=sumo1;
		
		model.addAttribute("things",sumo1);
		
		return "views/SumoBookingForm";
		
	
}
	
	
	
	@PostMapping("/sumoBooking")
	
	public String sumoBooking(@ModelAttribute("booking") Booking theBooking, Model model) {
		
		
		 
	 if(this.theSumo.getVacancy().equals(8))
	  this.theSumo.setVacancy(7);
	 
	 else  if(this.theSumo.getVacancy().equals(7))
		  this.theSumo.setVacancy(6);
	 
	 else  if(this.theSumo.getVacancy().equals(6))
		  this.theSumo.setVacancy(5);
	 
	 else  if(this.theSumo.getVacancy().equals(5))
		  this.theSumo.setVacancy(4);
	 
	 else  if(this.theSumo.getVacancy().equals(4))
		  this.theSumo.setVacancy(3);
	 
	 else  if(this.theSumo.getVacancy().equals(3))
		  this.theSumo.setVacancy(2);
	 
	 else  if(this.theSumo.getVacancy().equals(2))
		  this.theSumo.setVacancy(1);
	 
	 else  if(this.theSumo.getVacancy().equals(1))
		  this.theSumo.setVacancy(0);
	 
	
		
		
		if(theBooking.getSeat().equals("1"))
			this.theSumo.setSeat1("X");
		
		
		else if(theBooking.getSeat().equals("2"))
			this.theSumo.setSeat2("X");
		
		else if(theBooking.getSeat().equals("3"))
			this.theSumo.setSeat3("X");
		
		
		else if(theBooking.getSeat().equals("4"))
			this.theSumo.setSeat4("X");
		
		else if(theBooking.getSeat().equals("5"))
			this.theSumo.setSeat5("X");
		
		else if(theBooking.getSeat().equals("6"))
			this.theSumo.setSeat6("X");
		
		else if(theBooking.getSeat().equals("7"))
			this.theSumo.setSeat7("X");
		
		else if(theBooking.getSeat().equals("8"))
			this.theSumo.setSeat8("X");
		
		
		
		
		
		
		sumoRepository.save(this.theSumo);
		
		
		theBooking.setStatus("T");
		
		this.theBooking=theBooking;
		
		bookingRepository.save(theBooking);
		
		 // model.addAttribute("book", theBooking);
		 
			//model.addAttribute("districts",districtRepository.findAll());
		
			
			
			
			return "views/pay";
	
	}
	
	
	@GetMapping("/www.example.com/payment/success/")
	public String Hellosdf(Model model)
	
	{
		
		

		model.addAttribute("sumo", theSumo);
		model.addAttribute("districts",districtRepository.findAll());

	return "views/SumoForm";  
		
		
		
	}
	

	
}

	
	
