package com.barberbross.barberbross.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Endereco {

    private String rua;
    private String bairro;
    private String numero;
    private String cidade;
    private String estado;
}
