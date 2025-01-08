package com.Attrezzo.models;

import java.security.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "agendas")
public class Agenda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID agendaId;
	
	private Timestamp data;
	
	@JoinColumn(name = "id_cliente", referencedColumnName = "id")
	private Cliente clienteId;

	public UUID getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(UUID agendaId) {
		this.agendaId = agendaId;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}
	
	
}
