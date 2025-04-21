package com.barberbross.barberbross.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barberbross.barberbross.model.Agendamento;
import com.barberbross.barberbross.repository.AgendamentoRepository;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    public List<Agendamento> listarAgendamentos() {
        return repository.findAll();
    }

    public Agendamento salvarAgendamento( Agendamento agendamento ) {

        boolean agendado = repository.existsByDataAndHoraAndBarbeiro(
            agendamento.getData(),
            agendamento.getHora(),
            agendamento.getBarbeiro()
        );

        if ( agendado ) {
            throw new RuntimeException( "Esse horário já está agendado para esse barbeiro." );
        }
        
        return repository.save( agendamento );
    }
}
