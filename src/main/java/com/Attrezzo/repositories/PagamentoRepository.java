package com.Attrezzo.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Attrezzo.models.Cliente;
import com.Attrezzo.models.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, UUID>{

	
	List<Pagamento> findByClienteId(Cliente cliente);
}
