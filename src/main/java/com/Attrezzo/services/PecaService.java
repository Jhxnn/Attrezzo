package com.Attrezzo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Attrezzo.dtos.PecaDto;
import com.Attrezzo.models.Peca;
import com.Attrezzo.repositories.PecaRepository;

@Service
public class PecaService {

	@Autowired
	PecaRepository pecaRepository;
	
	public Peca findById(UUID id) {
		return pecaRepository.findById(id).orElseThrow(()-> new RuntimeException("cannot be found"));
	}
	public List<Peca> findAll(){
		return pecaRepository.findAll();
	}
	public Peca createPeca(PecaDto pecaDto) {
		var peca = new Peca();
		BeanUtils.copyProperties(pecaDto, peca);
		return pecaRepository.save(peca);
	}
	public Peca updatePeca(PecaDto pecaDto, UUID id) {
		var peca = findById(id);
		peca.setFuncao(pecaDto.funcao());
		peca.setNome(pecaDto.nome());
		peca.setQuantidade(pecaDto.quantidade());
		return pecaRepository.save(peca);
	}
	public void deletePeca(UUID id) {
		var peca = findById(id);
		pecaRepository.delete(peca);
	}
}
