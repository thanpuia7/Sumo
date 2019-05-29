package com.puipuia.thymeleaf.helloworld1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private String id;
	
	@Column(name="Name")
	private String Name;
	
	
	@Column(name="Address")
	private String Address;
	
	
	@Column(name="Seat")
	private String Seat;
	
	
	@Column(name="Status")
	private String Status;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getSeat() {
		return Seat;
	}


	public void setSeat(String seat) {
		Seat = seat;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	public Booking(String id, String name, String address, String seat, String status) {
		

		this.id = id;
		Name = name;
		Address = address;
		Seat = seat;
		Status = status;
	}


	public Booking(String name, String address, String seat, String status) {
		

		Name = name;
		Address = address;
		Seat = seat;
		Status = status;
	}


	public Booking() {
		

	}


	@Override
	public String toString() {
		return "Booking [id=" + id + ", Name=" + Name + ", Address=" + Address + ", Seat=" + Seat + ", Status=" + Status
				+ "]";
	}


	
	
	
	
}
