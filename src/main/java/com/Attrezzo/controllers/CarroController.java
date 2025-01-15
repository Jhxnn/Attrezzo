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

import com.Attrezzo.dtos.CarroDto;
import com.Attrezzo.models.Carro;
import com.Attrezzo.services.CarroService;

@RestController
@RequestMapping("/carro")
public class CarroController {

	
	@Autowired
	CarroService carroService;
	
	@GetMapping
	public ResponseEntity<List<Carro>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(carroService.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Carro> findById(@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(carroService.findById(id));
	}
	@PostMapping
	public ResponseEntity<Carro> createCarro(@RequestBody CarroDto carroDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(carroService.createCarro(carroDto));
	}
	@PutMapping("/{id}")
	public ResponseEntity<Carro> updateCarro(@RequestBody CarroDto carroDto,
			@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.CREATED).body(carroService.updateCarro(carroDto, id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Carro> deleteCarro(@PathVariable(name = "id")UUID id){
		carroService.deleteCarro(id);
		return ResponseEntity.noContent().build();
	}
}
