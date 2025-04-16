package com.barberbross.barberbross.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barberbross.barberbross.model.Cliente;
import com.barberbross.barberbross.service.ClienteService;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

import jakarta.validation.Valid;

@RestController
@RequestMapping( "/clientes" )
@CrossOrigin( origins =  "*" )
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping( "/{id}" )
    public Cliente buscarCliente( @PathVariable Long id ) {
        return clienteService.buscarPorId( id );
    }

    @PostMapping
    public ResponseEntity<?> novoCliente( @Valid @RequestBody Cliente cliente ) {
        return ResponseEntity.ok( clienteService.salvarCliente( cliente ) );
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<Cliente> atualizarCliente( @PathVariable Long id, @Valid @RequestBody Cliente cliente ) {
        Cliente clienteAtualizado = clienteService.atualizarCliente( id, cliente);
        return clienteAtualizado != null ? ResponseEntity.ok( clienteAtualizado ) : ResponseEntity.notFound().build();
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Empty> apagarCliente( @PathVariable Long id ) {
        return clienteService.excluirCliente( id ) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
