package com.server.hr;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.hr.model.Conje;

import com.server.hr.service.ConjeService;

@RestController
@RequestMapping("/conje")
public class ConjeResource {
	private final ConjeService conjeService;

	public ConjeResource(ConjeService conjeService) {
		this.conjeService=conjeService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Conje>> getAllConje(){
		List<Conje> conje=conjeService.findAllConje();
		return new ResponseEntity<>(conje,HttpStatus.OK);
	}
	@GetMapping("/find/{id_c}")
	public ResponseEntity<Conje> getConjeById(@PathVariable("id_c") Long id_c){
		Conje conje=conjeService.findConjeById(id_c);
		return new ResponseEntity<>(conje,HttpStatus.OK);
	}
    @PostMapping("/add")
    public ResponseEntity<Conje> addConje(@RequestBody Conje conje){
        Conje newconje=conjeService.addConje(conje); 
    	return new ResponseEntity<>(conje,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Conje> updateConje(@RequestBody Conje conje){
    	Conje updateconje=conjeService.UpdateConje(conje);
    	return new ResponseEntity<>(conje,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id_c}")
    public ResponseEntity<String> deleteConje(@PathVariable("id_c") Long id_c){
		conjeService.deleteConjeById(id_c);
		return new ResponseEntity<String>("Conje is deleted successfully !!!",HttpStatus.OK);
	}
}
