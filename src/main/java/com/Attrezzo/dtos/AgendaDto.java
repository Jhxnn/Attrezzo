package com.Attrezzo.dtos;

import java.security.Timestamp;
import java.util.UUID;

public record AgendaDto(Timestamp data, UUID clienteId) {

}
