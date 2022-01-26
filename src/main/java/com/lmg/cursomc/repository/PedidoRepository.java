package com.lmg.cursomc.repository;

import com.lmg.cursomc.domain.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lmg.cursomc.domain.Pedido;
import org.springframework.transaction.annotation.Transactional;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Transactional(readOnly = true)
    Page<Pedido> findByCliente(Cliente cliente, Pageable pageRequest);

}
