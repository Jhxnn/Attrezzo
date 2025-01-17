package com.Attrezzo.dtos;

import java.time.LocalDate;
import java.util.UUID;

public record PagamentoDto(UUID clienteId, double valor, LocalDate data) {

}
