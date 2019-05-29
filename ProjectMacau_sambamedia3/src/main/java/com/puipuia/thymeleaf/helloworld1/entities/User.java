package com.puipuia.thymeleaf.helloworld1.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



 

@Entity
public class User {
	
	@Id
	@Email
	@NotEmpty(message="Name field should not be empty")
	@Column(name="email")
	private String email;
	
	@NotEmpty(message="Name field should not be empty")
	@Column(name="name")
	private String name;
	
	@Size(min=2,max=200,message="Password should be between 2 to 20")
	@NotEmpty(message="Password field should not be empty")
	@Column(name="password")
	private String password;
	

	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.ALL
			})
	@JoinTable(name = "USER_ROLE", joinColumns={
			@JoinColumn(name = "USER_EMAIL", referencedColumnName = "email") }, inverseJoinColumns = {
					@JoinColumn(name = "ROLE_NAME", referencedColumnName = "name") })
	
	private List<Role> role;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public List<Role> getRoles() {
		return role;
	}
	public void setRoles(List<Role> role) {
		this.role = role;
	}
	
	
	public User(String email, String name, String password) {
		
		this.email = email;
		this.name = name;
		this.password = password;
	}
	
	public User(){
		
	}
	
	
	
}
