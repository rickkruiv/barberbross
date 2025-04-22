package com.barberbross.barberbross.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DiasFuncionamento {

    @Id @GeneratedValue
    private Long id;

    private String diaSemana;
}
