package com.Attrezzo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Attrezzo.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, UUID>{

}
