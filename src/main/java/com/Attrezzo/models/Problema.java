package com.Attrezzo.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "problemas")
public class Problema {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID problemaId;
	
	@Column(name = "nome_problema")
	private String problemaNome;
	
	@Column(name = "dias_conserto")
	private int diasConserto;
	
	@Column(name = "valor_base")
	private double valorBase;

	public UUID getProblemaId() {
		return problemaId;
	}

	public void setProblemaId(UUID problemaId) {
		this.problemaId = problemaId;
	}

	public String getProblemaNome() {
		return problemaNome;
	}

	public void setProblemaNome(String problemaNome) {
		this.problemaNome = problemaNome;
	}

	public int getDiasConserto() {
		return diasConserto;
	}

	public void setDiasConserto(int diasConserto) {
		this.diasConserto = diasConserto;
	}

	public double getValorBase() {
		return valorBase;
	}

	public void setValorBase(double valorBase) {
		this.valorBase = valorBase;
	}
	
	
}
