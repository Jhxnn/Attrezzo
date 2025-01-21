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

import com.Attrezzo.dtos.ClienteDto;
import com.Attrezzo.dtos.EmailDto;
import com.Attrezzo.models.Cliente;
import com.Attrezzo.services.ClienteService;
import com.Attrezzo.services.EmailService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	EmailService emailService;
	
	@GetMapping
	@Operation(description = "Lista todos os clientes")
	public ResponseEntity<List<Cliente>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
	}
	
	@Operation(description = "Lista cliente pelo ID")
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.findById(id));
	}
	
	@Operation(description = "Envia um email personalizado ao cliente")
	@GetMapping("/email")
	public ResponseEntity<String> emailPersonalizado(@RequestBody EmailDto emailDto){
		return ResponseEntity.status(HttpStatus.OK).body(emailService.enviarEmailTexto(emailDto.email(), emailDto.assunto(),emailDto.mensagem()));
		
	}
	
	@Operation(description = "Cria um cliente")
	@PostMapping
	public ResponseEntity<Cliente> createCliente(@RequestBody ClienteDto clienteDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.createCliente(clienteDto));
	}
	
	@Operation(description = "Atualiza um cliente")
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> updateCliente(@RequestBody ClienteDto clienteDto,
			@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.updateCliente(clienteDto, id));
	}
	
	@Operation(description = "Deleta um cliente")
	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> deleteCliente(@PathVariable(name = "id")UUID id){
		clienteService.deleteCliente(id);
		return ResponseEntity.noContent().build();
	}
}
