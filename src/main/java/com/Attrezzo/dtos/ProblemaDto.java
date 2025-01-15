package com.Attrezzo.dtos;

import java.util.UUID;

public record ProblemaDto(String problemaNome, int diasConserto, double valorBase, UUID pecaUtilizada) {

}
