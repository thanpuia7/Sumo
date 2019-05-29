package com.puipuia.thymeleaf.helloworld1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puipuia.thymeleaf.helloworld1.entities.District;



@Repository
public interface DistrictRepository extends JpaRepository<District, String> {

}
