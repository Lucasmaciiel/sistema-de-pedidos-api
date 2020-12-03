package com.lmg.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmg.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
