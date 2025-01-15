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

import com.Attrezzo.dtos.PecaDto;
import com.Attrezzo.models.Peca;
import com.Attrezzo.services.PecaService;

@RestController
@RequestMapping("/peca")
public class PecaController {

	
	@Autowired
	PecaService pecaService;
	
	@GetMapping
	public ResponseEntity<List<Peca>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(pecaService.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Peca> findById(@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(pecaService.findById(id));
	}
	@PostMapping
	public ResponseEntity<Peca> createPeca(@RequestBody PecaDto pecaDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(pecaService.createPeca(pecaDto));
	}
	@PutMapping("/{id}")
	public ResponseEntity<Peca> updatePeca(@RequestBody PecaDto pecaDto,
			@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.CREATED).body(pecaService.updatePeca(pecaDto, id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Peca> deletePeca(@PathVariable(name = "id")UUID id){
		pecaService.deletePeca(id);
		return ResponseEntity.noContent().build();
	}
}
