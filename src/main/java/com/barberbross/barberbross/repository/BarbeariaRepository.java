package com.barberbross.barberbross.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barberbross.barberbross.model.Barbearia;

public interface BarbeariaRepository extends JpaRepository<Barbearia, Long> {
    
}
