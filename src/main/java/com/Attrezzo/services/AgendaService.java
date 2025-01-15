package com.Attrezzo.services;

import java.security.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Attrezzo.dtos.AgendaDto;
import com.Attrezzo.models.Agenda;
import com.Attrezzo.repositories.AgendaRepository;

@Service
public class AgendaService {

	
	@Autowired
	AgendaRepository agendaRepository;
	
	@Autowired
	ClienteService clienteService;
	
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
