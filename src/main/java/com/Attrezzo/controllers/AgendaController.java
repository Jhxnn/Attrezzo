package com.Attrezzo.controllers;

import java.security.Timestamp;
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

import com.Attrezzo.dtos.AgendaDto;
import com.Attrezzo.models.Agenda;
import com.Attrezzo.services.AgendaService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

	
	@Autowired
	AgendaService agendaService;
	
	@Operation(description = "Lista todos as agendas")
	@GetMapping
	public ResponseEntity<List<Agenda>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(agendaService.findAll());
	}
	
	@Operation(description = "Lista agenda pelo ID")
	@GetMapping("/{id}")
	public ResponseEntity<Agenda> findById(@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(agendaService.findById(id));
	}
	
	@Operation(description = "Lista agendas pela data")
	@GetMapping("/data/{data}")
	public ResponseEntity<List<Agenda>> findById(@PathVariable(name = "data")Timestamp data){
		return ResponseEntity.status(HttpStatus.OK).body(agendaService.findByData(data));
	}
	
	@Operation(description = "Cria uma agenda e envia um email de aviso para o cliente")
	@PostMapping
	public ResponseEntity<Agenda> createAgenda(@RequestBody AgendaDto agendaDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(agendaService.createAgenda(agendaDto));
	}
	
	@Operation(description = "Atualiza uma agenda")
	@PutMapping("/{id}")
	public ResponseEntity<Agenda> updateAgenda(@RequestBody AgendaDto agendaDto,
			@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.CREATED).body(agendaService.updateAgenda(agendaDto, id));
	}
	
	@Operation(description = "Deleta uma agenda")
	@DeleteMapping("/{id}")
	public ResponseEntity<Agenda> deleteAgenda(@PathVariable(name = "id")UUID id){
		agendaService.deleteAgenda(id);
		return ResponseEntity.noContent().build();
	}
}
