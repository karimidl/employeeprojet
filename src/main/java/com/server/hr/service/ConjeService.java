package com.server.hr.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.hr.Exceptions.ConjeNotFoundException;

import com.server.hr.model.Conje;

import com.server.hr.reposi.ConjeRepo;

@Service
@Transactional
public class ConjeService {
	private final ConjeRepo conjeRepo;
	
	@Autowired
	public ConjeService (ConjeRepo conjeRepo) {
		this.conjeRepo=conjeRepo;
	}
	
	public Conje addConje(Conje conje) {
		return conjeRepo.save(conje);
	}
	public List<Conje> findAllConje(){
		return conjeRepo.findAll();
	}
	
	public Conje UpdateConje(Conje conje) {
		return conjeRepo.save(conje);
	}
	
    public Conje findConjeById(Long id_c) {
    	return conjeRepo.findConjeById(id_c).orElseThrow(()-> new ConjeNotFoundException("conje N°" +id_c+ "pas trouvé"));
    }
    public void deleteConjeById(Long id_c) {
    	 conjeRepo.deleteConjeById(id_c);
    }
}
