package com.Attrezzo.models;

import java.security.Timestamp;
import java.util.UUID;

import com.Attrezzo.models.enums.StatusCarro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	private Timestamp dataEntrada;
	
	private Timestamp dataSaida;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id")
	private Cliente clienteId;
	
	@ManyToOne
	@JoinColumn(name = "id_problema", referencedColumnName = "id")
	private Problema problemaId;
	
	private StatusCarro status;

	
	public StatusCarro getStatus() {
		return status;
	}
	
	public Timestamp getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Timestamp dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Timestamp getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Timestamp dataSaida) {
		this.dataSaida = dataSaida;
	}

	public void setStatus(StatusCarro status) {
		this.status = status;
	}

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
