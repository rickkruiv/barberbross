package com.barberbross.barberbross.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barberbross.barberbross.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
