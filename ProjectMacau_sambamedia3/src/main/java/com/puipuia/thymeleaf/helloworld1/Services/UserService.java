package com.puipuia.thymeleaf.helloworld1.Services;

import java.util.ArrayList;
import java.util.List;

import com.puipuia.thymeleaf.helloworld1.entities.Role;
import com.puipuia.thymeleaf.helloworld1.entities.User;
import com.puipuia.thymeleaf.helloworld1.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user) {
		BCryptPasswordEncoder  encoder = new  BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword())); 
		Role userRole = new Role("USER");
		List<Role> role = new ArrayList<>();
		role.add(userRole);
		user.setRoles(role);
		userRepository.save(user);
	}
	
	public void createAdmin(User user) {
		BCryptPasswordEncoder  encoder = new  BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword())); 
		Role userRole = new Role("ADMIN");
		List<Role> role = new ArrayList<>();
		role.add(userRole);
		user.setRoles(role);
		userRepository.save(user);
	}
	
	public User findOne(String email) {
		
	  return userRepository.findByEmail(email);
	}

	public boolean isUserPresent(String email) {
		// TODO Auto-generated method stub
		User u=userRepository.findByEmail(email);
		if(u!=null)
			return true;
		
		return false;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return  userRepository.findByNameLike("%"+name+"%");
	}

}
