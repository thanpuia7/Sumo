package com.puipuia.thymeleaf.helloworld1.entities;

public enum SeatNo {

	FIRST("First"),
	SECOND("Second"),
	THIRD("Third"),
	FOURTH("Fourth"),
	FIFTH("Fifth"),
	SIXTH("Sixth"),
	SEVEN("Seven");
	
	
	private final String seat;
	
	SeatNo(String seat){
		this.seat=seat;
	}
	
	public String getSeat() {
		return seat;
		
	}
}
