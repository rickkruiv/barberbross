package com.barberbross.barberbross.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barberbross.barberbross.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
