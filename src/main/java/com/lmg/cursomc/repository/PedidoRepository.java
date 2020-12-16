package com.lmg.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmg.cursomc.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
