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

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/peca")
public class PecaController {

	
	@Autowired
	PecaService pecaService;
	
	
	@Operation(description = "Lista todas as peças")
	@GetMapping
	public ResponseEntity<List<Peca>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(pecaService.findAll());
	}
	
	@Operation(description = "Lista peça pelo ID")
	@GetMapping("/{id}")
	public ResponseEntity<Peca> findById(@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(pecaService.findById(id));
	}
	
	@Operation(description = "Lista peça mais utilizada")
	@GetMapping("/comum")
	public ResponseEntity<List<Object[]>> mostCommonPart(){
		return ResponseEntity.status(HttpStatus.OK).body(pecaService.mostCommonPart());
	}
	
	@Operation(description = "Cria uma peça")
	@PostMapping
	public ResponseEntity<Peca> createPeca(@RequestBody PecaDto pecaDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(pecaService.createPeca(pecaDto));
	}
	
	@Operation(description = "Atualiza a quantidade de uma peça especifica no estoque")
	@PutMapping("/consumo/{id}/{qnt}")
	public ResponseEntity<Peca> consumoPeca(@PathVariable(name = "id")UUID id,
			@PathVariable(name = "qnt")int qnt){
		return ResponseEntity.status(HttpStatus.CREATED).body(pecaService.consumoPeca(qnt, id));
	}
	
	@Operation(description = "Atualiza uma peça")
	@PutMapping("/{id}")
	public ResponseEntity<Peca> updatePeca(@RequestBody PecaDto pecaDto,
			@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.CREATED).body(pecaService.updatePeca(pecaDto, id));
	}
	
	@Operation(description = "Deleta uma peça")
	@DeleteMapping("/{id}")
	public ResponseEntity<Peca> deletePeca(@PathVariable(name = "id")UUID id){
		pecaService.deletePeca(id);
		return ResponseEntity.noContent().build();
	}
}
