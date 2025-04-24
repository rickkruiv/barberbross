package com.barberbross.barberbross.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barberbross.barberbross.dto.AgendamentoDTO;
import com.barberbross.barberbross.model.Agendamento;
import com.barberbross.barberbross.model.Barbearia;
import com.barberbross.barberbross.model.Barbeiro;
import com.barberbross.barberbross.model.Cliente;
import com.barberbross.barberbross.model.Servico;
import com.barberbross.barberbross.repository.AgendamentoRepository;
import com.barberbross.barberbross.repository.BarbeariaRepository;
import com.barberbross.barberbross.repository.BarbeiroRepository;
import com.barberbross.barberbross.repository.ClienteRepository;
import com.barberbross.barberbross.repository.ServicoRepository;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Autowired
    private ServicoRepository servicoRepository ;

    @Autowired
    private BarbeariaRepository barbeariaRepository ;

    public List<Agendamento> listarAgendamentos() {
        return repository.findAll();
    }

    public Agendamento salvarAgendamento( AgendamentoDTO agendamentoDTO ) {

        Agendamento agendamento = new Agendamento();
        
        agendamento.setData( agendamentoDTO.getData() );
        agendamento.setHora( agendamentoDTO.getHora() );

        Cliente cliente = clienteRepository.findById( agendamentoDTO.getClienteId() )
                .orElseThrow( () -> new RuntimeException("Cliente não cadastrado") );

        Barbeiro barbeiro = barbeiroRepository.findById( agendamentoDTO.getBarbeiroId() )
                .orElseThrow( () -> new RuntimeException("Barbeiro não encontrado") );

         Servico servico = servicoRepository.findById(agendamentoDTO.getServicoId() )
                .orElseThrow( () -> new RuntimeException("Serviço não encontrado") );

        Barbearia barbearia = barbeariaRepository.findById( agendamentoDTO.getBarbeariaId() )
                .orElseThrow( () -> new RuntimeException( "Barbearia não encontrada") );

        boolean agendado = repository.existsByDataAndHoraAndBarbeiro(
            agendamento.getData(),
            agendamento.getHora(),
            barbeiro
        );

        if ( agendado ) {
            throw new RuntimeException( "Esse horario ja esta agendado para esse barbeiro." );
        }

        if ( !barbeiro.getBarbearia().getId().equals( barbearia.getId() ) ) {
            throw new RuntimeException( "O barbeiro nao pertence a barbearia informada" );
        }

        if ( !servico.getBarbearia().getId().equals( barbearia.getId() ) ) {
            throw new RuntimeException( "O servico nao pertence a barbearia informada" );
        }

        agendamento.setCliente( cliente );
        agendamento.setBarbeiro( barbeiro );
        agendamento.setServico( servico );
        agendamento.setBarbearia( barbearia );
        
        return repository.save( agendamento );
    }
}
