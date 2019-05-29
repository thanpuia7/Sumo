package com.puipuia.thymeleaf.helloworld1.Repositories;


import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.puipuia.thymeleaf.helloworld1.entities.Sumo;


@Repository

public interface SumoRepository extends CrudRepository<Sumo, String>{
	
       @Query(value="SELECT * FROM Sumo WHERE Fromm=?1 AND Too=?2 AND Datee=?3",nativeQuery=true)
  
     public  List<Sumo> findByFromAndToAndDate(String From,String To,String Date);
       
       

}
