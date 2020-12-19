package com.lmg.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmg.cursomc.domain.Pedido;
import com.lmg.cursomc.repository.PedidoRepository;
import com.lmg.cursomc.service.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository repository;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> pedido = repository.findById(id);
		return pedido.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ID: " + id
				+ ", Tipo" + Pedido.class.getName()));
	}	
}
