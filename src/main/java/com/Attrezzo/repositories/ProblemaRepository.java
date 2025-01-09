package com.Attrezzo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Attrezzo.models.Problema;

public interface ProblemaRepository extends JpaRepository<Problema, UUID>{

}
