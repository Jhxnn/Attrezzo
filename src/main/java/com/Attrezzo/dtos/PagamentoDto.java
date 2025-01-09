package com.Attrezzo.dtos;

import java.util.UUID;

public record PagamentoDto(UUID clienteId, double valor) {

}
