package com.Attrezzo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Attrezzo.dtos.ClienteDto;
import com.Attrezzo.models.Cliente;
import com.Attrezzo.repositories.ClienteRepository;

@Service
public class ClienteService {

	
	@Autowired
	ClienteRepository clienteRepository;
	
	
	public Cliente findById(UUID id) {
		return clienteRepository.findById(id).orElseThrow(()-> new RuntimeException("cannot be found"));
	}
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	public Cliente createCliente(ClienteDto clienteDto) {
		var cliente = new Cliente();
		BeanUtils.copyProperties(clienteDto, cliente);
		return clienteRepository.save(cliente);
	}
	public Cliente updateCliente(ClienteDto clienteDto, UUID id) {
		var cliente = findById(id);
		cliente.setCpf(clienteDto.cpf());
		cliente.setEmail(clienteDto.email());
		cliente.setNome(clienteDto.nome());
		cliente.setTelefone(clienteDto.telefone());
		return clienteRepository.save(cliente);
	}
	public void deleteCliente(UUID id) {
		var cliente = findById(id);
		clienteRepository.delete(cliente);
	}
}
