package com.puipuia.thymeleaf.helloworld1.Repositories;

import java.util.List;

import com.puipuia.thymeleaf.helloworld1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, String> {

	List<User> findByNameLike(String name);

	User findByEmail(String email); 

}
