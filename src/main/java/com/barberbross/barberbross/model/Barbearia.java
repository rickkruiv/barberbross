package com.barberbross.barberbross.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Barbearia {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @NotBlank( message = "Nome nao pode ser vazio" )
    private String nome;

    @NotBlank( message = "Data nao pode ser vazia")
    private LocalDate dataCadastro;

    @Embedded
    private Endereco endereco;

    @OneToMany( mappedBy = "barbearia", cascade = CascadeType.ALL )
    private List<Barbeiro> barbeiros = new ArrayList<>();

    @OneToMany( mappedBy = "barbearia", cascade = CascadeType.ALL )
    private List<Servico> servicos = new ArrayList<>();

    @OneToMany( mappedBy = "barbearia", cascade = CascadeType.ALL )
    private List<Agendamento> agendamentos;

    @ManyToMany
    private List<DiasFuncionamento> diasFuncionamento  = new ArrayList<>();

    @ManyToOne
    private HorarioFuncionamento horarioFuncionamento;

    @PrePersist
    public void prePersist() { 
        this.dataCadastro = LocalDate.now(); 
    }
}
