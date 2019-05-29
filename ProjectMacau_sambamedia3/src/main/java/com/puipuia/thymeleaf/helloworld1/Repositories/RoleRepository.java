package com.puipuia.thymeleaf.helloworld1.Repositories;

import com.puipuia.thymeleaf.helloworld1.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role, String>{
 
}
