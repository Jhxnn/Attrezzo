package com.Attrezzo.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Attrezzo.models.Problema;

public interface ProblemaRepository extends JpaRepository<Problema, UUID>{

	@Query("SELECT p.problemaNome, COUNT(p) AS quantidade " +
	           "FROM Problema p " +
	           "GROUP BY p.problemaNome " +
	           "ORDER BY quantidade DESC")
		List<Object[]> findMostCommonProblems();

	
		@Query("SELECT p.pecaUtilizada, COUNT(p) AS quantidade " +
		           "FROM Problema p " +
		           "GROUP BY p.pecaUtilizada " +
		           "ORDER BY quantidade DESC")
			List<Object[]> findMostCommonPart();

	
}
