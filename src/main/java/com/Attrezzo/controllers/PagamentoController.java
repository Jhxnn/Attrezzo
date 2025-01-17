package com.Attrezzo.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

import com.Attrezzo.dtos.PagamentoDto;
import com.Attrezzo.models.Pagamento;
import com.Attrezzo.services.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

	
	@Autowired
	PagamentoService pagService;
	
	@GetMapping
	public ResponseEntity<List<Pagamento>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(pagService.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Pagamento> findById(@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(pagService.findById(id));
	}
	@GetMapping("/cliente/{clienteId}")
	public ResponseEntity<List<Pagamento>> findByCliente(@PathVariable(name = "clienteId")UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(pagService.findByCliente(id));
	}
	@GetMapping("/mensal/{data}")
	public ResponseEntity<byte[]> relatorioMensal(@PathVariable(name = "data")LocalDate data){
		byte[] pdfBytes = pagService.pdfPagamento(data);

	    HttpHeaders headers = new HttpHeaders();
	    headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=relatorio.pdf");
	    headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
	    return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Pagamento> createPagamento(@RequestBody PagamentoDto pagDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(pagService.createPagamento(pagDto));
	}
	@PutMapping("/{id}")
	public ResponseEntity<Pagamento> updatePagamento(@RequestBody PagamentoDto pagDto,
			@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.CREATED).body(pagService.updatePagamento(pagDto, id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Pagamento> deletePagamento(@PathVariable(name = "id")UUID id){
		pagService.deletePagamento(id);
		return ResponseEntity.noContent().build();
	}
}
