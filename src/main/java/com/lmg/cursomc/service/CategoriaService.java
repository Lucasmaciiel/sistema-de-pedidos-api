package com.lmg.cursomc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.lmg.cursomc.domain.Categoria;
import com.lmg.cursomc.repository.CategoriaRepository;
import com.lmg.cursomc.service.exception.DataIntegrityException;
import com.lmg.cursomc.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository repository;
	
	public Categoria find(Integer id) {
		Optional<Categoria> categoria = repository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ID: " + id
				+ ", Tipo" + Categoria.class.getName()));
	}	
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		 find(id); // caso o id não exista ja despera a excessão
		 try {
			 repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível deletar uma categoria que contenha produtos vinculados. ID:  " 
					+ id);
		}
		
	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}
	
}
