package com.lmg.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmg.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
