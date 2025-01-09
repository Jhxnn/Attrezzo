package com.Attrezzo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Attrezzo.models.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, UUID>{

}
