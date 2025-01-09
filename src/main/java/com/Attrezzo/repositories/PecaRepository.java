package com.Attrezzo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Attrezzo.models.Peca;

public interface PecaRepository extends JpaRepository<Peca, UUID>{

}
