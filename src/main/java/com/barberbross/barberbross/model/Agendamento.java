package com.barberbross.barberbross.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.barberbross.barberbross.enums.StatusAgendamento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Agendamento {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    @NotBlank( message = "Data é obrigatório" )
    private LocalDate data;
    
    @NotBlank( message = "Hora é obrigatório" )
    private LocalTime hora;

    private StatusAgendamento status;

    @ManyToOne
    @JoinColumn( name = "cliente_id" )
    private Cliente cliente;

    @ManyToOne
    @JoinColumn( name = "barbeiro_id" )
    private Barbeiro barbeiro;

    @ManyToOne
    @JoinColumn( name = "servico_id" )
    private Servico servico;
}
