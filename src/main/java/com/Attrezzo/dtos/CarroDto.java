package com.Attrezzo.dtos;

import java.util.UUID;

import com.Attrezzo.models.enums.StatusCarro;

public record CarroDto(String marca, String modelo, UUID clienteId, UUID problemaId, StatusCarro status) {

}
