package com.Attrezzo.repositories;

import java.security.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Attrezzo.models.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, UUID>{
	
	List<Agenda> findByData(Timestamp data);
}
