package com.Attrezzo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.Attrezzo.dtos.ProblemaDto;
import com.Attrezzo.models.Problema;
import com.Attrezzo.services.ProblemaService;

@RestController
@RequestMapping("/problema")
public class ProblemaController {

	
	@Autowired
	ProblemaService probService;
	
	@GetMapping
	public ResponseEntity<List<Problema>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(probService.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Problema> findById(@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(probService.findById(id));
	}
	@PostMapping
	public ResponseEntity<Problema> createProblema(@RequestBody ProblemaDto probDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(probService.createProblema(probDto));
	}
	@PutMapping("/{id}")
	public ResponseEntity<Problema> updateProblema(@RequestBody ProblemaDto probDto,
			@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.CREATED).body(probService.updateProblema(probDto, id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Problema> deleteProblema(@PathVariable(name = "id")UUID id){
		probService.deleteProblema(id);
		return ResponseEntity.noContent().build();
	}
}
