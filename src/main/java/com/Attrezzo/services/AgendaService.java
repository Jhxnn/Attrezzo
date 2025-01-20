package com.Attrezzo.services;

import java.security.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Attrezzo.dtos.AgendaDto;
import com.Attrezzo.models.Agenda;
import com.Attrezzo.models.Cliente;
import com.Attrezzo.repositories.AgendaRepository;

@Service
public class AgendaService {

	
	@Autowired
	AgendaRepository agendaRepository;
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	EmailService emailService;
	
	
	public Agenda findById(UUID id) {
		return agendaRepository.findById(id).orElseThrow(()-> new RuntimeException("cannot be found"));
	}
	public List<Agenda> findAll(){
		return agendaRepository.findAll();
	}
	public List<Agenda> findByData(Timestamp data){
		return agendaRepository.findByData(data);
	}
	
	
	public Agenda createAgenda(AgendaDto agendaDto) {
		var agenda = new Agenda();
		BeanUtils.copyProperties(agendaDto, agenda);
		Cliente cliente = agenda.getClienteId();
		emailService.enviarEmailTexto(cliente.getEmail(), "Agendamento" , "Bom dia, " + cliente.getNome()
		+ " sua vinda ficou marcada para o dia: " + agenda.getData());
		return agendaRepository.save(agenda);
	}
	public Agenda updateAgenda(AgendaDto agendaDto, UUID id) {
		var agenda = findById(id);
		agenda.setClienteId(clienteService.findById(agendaDto.clienteId()));
		agenda.setData(agendaDto.data());
		return agendaRepository.save(agenda);
	}
	public void deleteAgenda(UUID id) {
		var agenda = findById(id);
		agendaRepository.delete(agenda);
	}
	
}
