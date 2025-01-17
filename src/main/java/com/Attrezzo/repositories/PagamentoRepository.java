package com.Attrezzo.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Attrezzo.models.Cliente;
import com.Attrezzo.models.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, UUID>{

	
	List<Pagamento> findByClienteId(Cliente cliente);
	
	@Query("SELECT p FROM Pagamento p WHERE p.data BETWEEN :inicio AND :fim")
	List<Pagamento> findByDatas(LocalDate inicio, LocalDate fim);
}
