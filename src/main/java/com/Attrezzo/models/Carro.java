package com.Attrezzo.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "carros")
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID carroId;
	
	private String marca;
	
	private String modelo;
	
	@JoinColumn(name = "id_cliente", referencedColumnName = "id")
	private Cliente clienteId;
	
	@JoinColumn(name = "id_problema", referencedColumnName = "id")
	private Problema problemaId;

	public UUID getCarroId() {
		return carroId;
	}

	public void setCarroId(UUID carroId) {
		this.carroId = carroId;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}

	public Problema getProblemaId() {
		return problemaId;
	}

	public void setProblemaId(Problema problemaId) {
		this.problemaId = problemaId;
	}
	
//	private StatusCarro status;
	
	
	
}
