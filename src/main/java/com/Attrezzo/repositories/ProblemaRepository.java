package com.Attrezzo.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Attrezzo.models.Problema;

public interface ProblemaRepository extends JpaRepository<Problema, UUID>{

	@Query("SELECT p.nome_problema, COUNT(p) AS ocorrencias " +
		       "FROM Problema p " +
		       "GROUP BY p.nome_problema " +
		       "ORDER BY ocorrencias DESC")
		List<Object[]> findMostCommonProblems();
	
	@Query("SELECT p.peca_utilizada, COUNT(p) AS ocorrencias " +
		       "FROM Problema p " +
		       "GROUP BY p.peca_utilizada " +
		       "ORDER BY ocorrencias DESC")
		List<Object[]> findMostCommmonPart();
	
}
