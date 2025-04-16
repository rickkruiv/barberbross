package com.barberbross.barberbross.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    @NotBlank( message = "Nome é obrigatório" )
    private String nome;
    
    @NotBlank( message = "Telefone é obrigatório" )
    private String telefone;
    
    @NotBlank( message = "Email é obrigatório" )
    private String email;

    private LocalDate dataCadastro;

    @OneToMany( mappedBy = "cliente" )
    @JsonIgnore 
    private List<Agendamento> agendamentos = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.dataCadastro = LocalDate.now();
    }
}
