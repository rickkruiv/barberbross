package com.barberbross.barberbross.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class AgendamentoDTO {

    private LocalDate data;
    private LocalTime hora;
    private Long barbeiroId;
    private Long clienteId;
    private Long servicoId;
    private Long barbeariaId;
}
