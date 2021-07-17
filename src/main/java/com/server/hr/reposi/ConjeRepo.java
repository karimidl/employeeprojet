package com.server.hr.reposi;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.hr.model.Conje;


public interface ConjeRepo extends JpaRepository<Conje,Long>{
	
	
	  Optional<Conje> findConjeById(Long id);
	  void deleteConjeById(Long id);


}
