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
import com.Attrezzo.models.enums.StatusCarro;
import com.Attrezzo.services.CarroService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/carro")
public class CarroController {

	
	@Autowired
	CarroService carroService;
	
	
	@Operation(description = "Lista todos os carros")
	@GetMapping
	public ResponseEntity<List<Carro>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(carroService.findAll());
	}
	
	@Operation(description = "Lista carro pelo ID")
	@GetMapping("/{id}")
	public ResponseEntity<Carro> findById(@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(carroService.findById(id));
	}
	
	@Operation(description = "Lista todos os carros com o status pedido")
	@GetMapping("/status/{status}")
	public ResponseEntity<List<Carro>> findByStatus(@PathVariable(name = "status")StatusCarro status){
		return ResponseEntity.status(HttpStatus.OK).body(carroService.findByStatus(status));
	}
	
	@Operation(description = "Cria um carro")
	@PostMapping
	public ResponseEntity<Carro> createCarro(@RequestBody CarroDto carroDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(carroService.createCarro(carroDto));
	}
	
	@Operation(description = "Atualiza um carro")
	@PutMapping("/{id}")
	public ResponseEntity<Carro> updateCarro(@RequestBody CarroDto carroDto,
			@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.CREATED).body(carroService.updateCarro(carroDto, id));
	}
	
	@Operation(description = "Atualiza o status de um carro")
	@PutMapping("/status/{status}/{idCarro}")
	public ResponseEntity<Carro> updateStatus(@PathVariable(name = "status")StatusCarro status,
			@PathVariable(name = "idCarro")UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(carroService.updateStatus(status, id));
	}
	
	
	@Operation(description = "Deleta um carro")
	@DeleteMapping("/{id}")
	public ResponseEntity<Carro> deleteCarro(@PathVariable(name = "id")UUID id){
		carroService.deleteCarro(id);
		return ResponseEntity.noContent().build();
	}
}
