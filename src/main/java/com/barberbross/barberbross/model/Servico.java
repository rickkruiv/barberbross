package com.barberbross.barberbross.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Servico {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    @NotBlank( message = "Nome é obrigatório" )
    private String nome;
    
    private Integer duracao;

    @NotBlank( message = "Preco é obrigatório" )
    private BigDecimal preco;

    @OneToMany( mappedBy = "servico" )
    @JsonIgnore 
    private List<Agendamento> agendamentos = new ArrayList<>();
}
