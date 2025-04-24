package com.barberbross.barberbross.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barberbross.barberbross.model.Agendamento;
import com.barberbross.barberbross.model.Barbeiro;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    boolean existsByDataAndHoraAndBarbeiro( LocalDate data, LocalTime hora, Barbeiro barbeiro ); 
}
