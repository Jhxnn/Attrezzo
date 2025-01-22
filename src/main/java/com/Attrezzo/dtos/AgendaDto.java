	package com.Attrezzo.dtos;

import java.time.LocalDate;
import java.util.UUID;

public record AgendaDto(LocalDate data, UUID clienteId) {

}
