package com.Attrezzo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Attrezzo.models.Carro;

public interface CarroRepository extends JpaRepository<Carro, UUID>{

}
