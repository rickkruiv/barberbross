package com.barberbross.barberbross.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Servico {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    private String nome;
    private Integer duracao;
    private BigDecimal preco;

    @OneToMany( mappedBy = "servico" )
    private List<Agendamento> agendamentos = new ArrayList<>();
}
