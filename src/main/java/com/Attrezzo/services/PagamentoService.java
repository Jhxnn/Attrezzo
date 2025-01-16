package com.Attrezzo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Attrezzo.dtos.PagamentoDto;
import com.Attrezzo.models.Pagamento;
import com.Attrezzo.repositories.PagamentoRepository;

@Service
public class PagamentoService {

	
	@Autowired
	PagamentoRepository pagRepository;
	
	@Autowired
	ClienteService clienteService;
	
	public Pagamento findById(UUID id) {
		return pagRepository.findById(id).orElseThrow(()-> new RuntimeException("cannot be found"));
	}
	public List<Pagamento> findAll(){
		return pagRepository.findAll();
	}
	public List<Pagamento> findByCliente(UUID id){
		var cliente = clienteService.findById(id);
		return pagRepository.findByClienteId(cliente);
	}
	public Pagamento createPagamento(PagamentoDto pagDto) {
		var pagamento = new Pagamento();
		BeanUtils.copyProperties(pagDto, pagamento);
		return pagRepository.save(pagamento);
	}
	public Pagamento updatePagamento(PagamentoDto pagDto, UUID id) {
		var pagamento = findById(id);
		pagamento.setClienteId(clienteService.findById(pagDto.clienteId()));
		pagamento.setValor(pagDto.valor());
		return pagRepository.save(pagamento);
	}
	public void deletePagamento(UUID id) {
		var pagamento = findById(id);
		pagRepository.delete(pagamento);
	}
}
