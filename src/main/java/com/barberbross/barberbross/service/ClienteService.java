package com.barberbross.barberbross.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.barberbross.barberbross.model.Cliente;
import com.barberbross.barberbross.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listarClientes() {
        return repository.findAll();
    }

    public Cliente salvarCliente( Cliente cliente ) {
        return repository.save( cliente );
    }

    public Cliente buscarPorId( Long id ) {
        return repository.findById( id )
                .orElseThrow( () -> new ResponseStatusException( 
                    HttpStatus.NOT_FOUND, "Cliente nao encontrado" 
                ) ) ;
    }

    public Cliente atualizarCliente( Long id, Cliente clienteAtualizado ) {

        Optional<Cliente> existe = repository.findById( id );

        if ( existe.isPresent() ) {
            Cliente cliente = existe.get();
            cliente.setNome( clienteAtualizado.getNome() );
            cliente.setEmail( clienteAtualizado.getEmail() );
            cliente.setTelefone( clienteAtualizado.getTelefone());
            cliente.setAgendamentos( clienteAtualizado.getAgendamentos());

            return repository.save( cliente );
        }
        return null;
    }

    public boolean excluirCliente( Long id ) {

        if ( repository.existsById( id ) ) {
            repository.deleteById( id );
            return true;
        }
        return false;
    }
}
