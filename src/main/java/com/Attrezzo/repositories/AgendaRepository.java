package com.Attrezzo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Attrezzo.models.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, UUID>{

}
