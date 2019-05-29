package com.puipuia.thymeleaf.helloworld1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="District")
public class District {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public District(String name, String id) {
		
		this.name = name;
		this.id = id;
	}

	public District(String name) {
		
		this.name = name;
	}

	public District() {
		
	}

	@Override
	public String toString() {
		return "District [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
