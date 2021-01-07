package com.lmg.cursomc.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lmg.cursomc.domain.ItemPedido;
import com.lmg.cursomc.domain.PagamentoComBoleto;
import com.lmg.cursomc.domain.Pedido;
import com.lmg.cursomc.domain.enums.EstadoPagamento;
import com.lmg.cursomc.repository.ItemPedidoRepository;
import com.lmg.cursomc.repository.PagamentoRepository;
import com.lmg.cursomc.repository.PedidoRepository;
import com.lmg.cursomc.service.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository repository;
	@Autowired
	BoletoService boletoService;
	@Autowired
	PagamentoRepository pagamentoRepository;
	@Autowired
	ProdutoService produtoService;
//	
//	@Autowired
//	ProdutoRepository produtoRepository;
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
	public Pedido find(Integer id) {
		Optional<Pedido> pedido = repository.findById(id);
		return pedido.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ID: " + id
				+ ", Tipo" + Pedido.class.getName()));
	}	
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if(obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pgto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pgto, obj.getInstante());
		}
		obj = repository.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for(ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		return obj;
		
		
	}
}





















