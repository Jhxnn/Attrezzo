package com.Attrezzo.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Attrezzo.models.Carro;
import com.Attrezzo.models.enums.StatusCarro;

public interface CarroRepository extends JpaRepository<Carro, UUID>{

	List<Carro> findByStatus(StatusCarro status);
}
