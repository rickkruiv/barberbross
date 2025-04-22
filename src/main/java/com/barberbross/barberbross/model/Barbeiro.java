package com.barberbross.barberbross.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Barbeiro {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    
    @NotBlank( message = "Nome é obrigatório" )
    private String nome;
    private String especialidade;

    @ElementCollection
    private List<String> diasDisponiveis = new ArrayList<>();

    @ElementCollection
    private List<String> horariosDisponiveis = new ArrayList<>();

    @OneToMany( mappedBy = "barbeiro" )
    @JsonIgnore 
    private List<Agendamento> agendamentos = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn( name = "barbearia_id" )
    @JsonIgnore
    private Barbearia barbearia;

}
