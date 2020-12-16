package com.lmg.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmg.cursomc.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
