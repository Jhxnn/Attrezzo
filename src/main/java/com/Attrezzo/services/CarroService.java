package com.Attrezzo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Attrezzo.dtos.CarroDto;
import com.Attrezzo.models.Carro;
import com.Attrezzo.models.enums.StatusCarro;
import com.Attrezzo.repositories.CarroRepository;

@Service
public class CarroService {

	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ProblemaService problemaService;
	
	public Carro findById(UUID id) {
		return carroRepository.findById(id).orElseThrow(()-> new RuntimeException("Nâo foi possivel encontrar"));
	}
	public List<Carro> findAll(){
		return carroRepository.findAll();
	}
	
	public List<Carro> findByStatus(StatusCarro status){
		return carroRepository.findByStatus(status);
	}
	public Carro createCarro(CarroDto carroDto) {
		var carro = new Carro();
		var cliente = clienteService.findById(carroDto.clienteId());
		BeanUtils.copyProperties(carroDto, carro);
		carro.setClienteId(cliente);
		return carroRepository.save(carro);
	}
	
	public Carro updateStatus(StatusCarro status, UUID idCarro) {
		var carro = findById(idCarro);
		carro.setStatus(status);
		return carroRepository.save(carro);
	}
	
	
	public Carro updateCarro(CarroDto carroDto, UUID id) {
		var carro = findById(id);
		carro.setClienteId(clienteService.findById(carroDto.clienteId()));
		carro.setMarca(carroDto.marca());
		carro.setModelo(carroDto.modelo());
		carro.setStatus(carroDto.status());
		carro.setProblemaId(problemaService.findById(carroDto.problemaId()));
		carro.setDataEntrada(carroDto.dataEntrada());
		carro.setDataSaida(carroDto.dataSaida());
		return carroRepository.save(carro);
	}
	public void deleteCarro(UUID id) {
		var peca = findById(id);
		carroRepository.delete(peca);
	}
}
