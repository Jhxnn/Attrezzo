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

import com.Attrezzo.dtos.AgendaDto;
import com.Attrezzo.models.Agenda;
import com.Attrezzo.services.AgendaService;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

	
	@Autowired
	AgendaService agendaService;
	
	@GetMapping
	public ResponseEntity<List<Agenda>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(agendaService.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Agenda> findById(@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(agendaService.findById(id));
	}
	@PostMapping
	public ResponseEntity<Agenda> createAgenda(@RequestBody AgendaDto agendaDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(agendaService.createAgenda(agendaDto));
	}
	@PutMapping("/{id}")
	public ResponseEntity<Agenda> updateAgenda(@RequestBody AgendaDto agendaDto,
			@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.CREATED).body(agendaService.updateAgenda(agendaDto, id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Agenda> deleteAgenda(@PathVariable(name = "id")UUID id){
		agendaService.deleteAgenda(id);
		return ResponseEntity.noContent().build();
	}
}
