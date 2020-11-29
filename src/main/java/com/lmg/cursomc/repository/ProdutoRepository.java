package com.lmg.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmg.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
