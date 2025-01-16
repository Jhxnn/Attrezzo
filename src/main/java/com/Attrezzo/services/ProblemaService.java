package com.Attrezzo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Attrezzo.dtos.ProblemaDto;

import com.Attrezzo.models.Problema;
import com.Attrezzo.repositories.ProblemaRepository;

@Service
public class ProblemaService {

	
	@Autowired
	ProblemaRepository problemaRepository;
	
	@Autowired
	PecaService pecaService;
	
	public Problema findById(UUID id) {
		return problemaRepository.findById(id).orElseThrow(()-> new RuntimeException("cannot be found"));
	}
	public List<Problema> findAll(){
		return problemaRepository.findAll();
	}
	
	public List<Problema> commonProblems(){
		return problemaRepository.findMostCommonProblems();
	}
	public Problema createProblema(ProblemaDto problemaDto) {
		var problema = new Problema();
		BeanUtils.copyProperties(problemaDto, problema);
		return problemaRepository.save(problema);
	}
	public Problema updateProblema(ProblemaDto problemaDto, UUID id) {
		var problema = findById(id);
		problema.setDiasConserto(problemaDto.diasConserto());
		problema.setProblemaNome(problemaDto.problemaNome());
		problema.setValorBase(problemaDto.valorBase());
		problema.setPecaUtilizada(pecaService.findById(problemaDto.pecaUtilizada()));
		return problemaRepository.save(problema);
	}
	public void deleteProblema(UUID id) {
		var problema = findById(id);
		problemaRepository.delete(problema);
	}
}
