package com.Attrezzo.dtos;

import java.security.Timestamp;
import java.util.UUID;

import com.Attrezzo.models.enums.StatusCarro;

public record CarroDto(String marca, String modelo,Timestamp dataEntrada, Timestamp dataSaida, UUID clienteId, UUID problemaId, StatusCarro status) {

}
