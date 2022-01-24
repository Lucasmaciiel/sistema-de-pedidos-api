package com.lmg.cursomc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lmg.cursomc.domain.Cidade;
import com.lmg.cursomc.domain.Cliente;
import com.lmg.cursomc.domain.Endereco;
import com.lmg.cursomc.domain.enums.TipoCliente;
import com.lmg.cursomc.dto.ClienteDTO;
import com.lmg.cursomc.dto.ClienteNewDTO;
import com.lmg.cursomc.repository.CidadeRepository;
import com.lmg.cursomc.repository.ClienteRepository;
import com.lmg.cursomc.repository.EnderecoRepository;
import com.lmg.cursomc.service.exception.DataIntegrityException;
import com.lmg.cursomc.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private BCryptPasswordEncoder pe;

	public Cliente find(Integer id) {
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Cliente não encontrado ID: " + id + ", Tipo" + Cliente.class.getName()));
	}

	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repository.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}

	public Cliente update(Cliente obj) {
		Cliente newObjt = find(obj.getId());
		updateData(newObjt, obj);
		return repository.save(newObjt);
	}

	public void delete(Integer id) {
		find(id); // caso o id não exista ja despera a excessão
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionadas");
		}

	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	public Cliente fromDto(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null, null);
	}

	public Cliente fromDto(ClienteNewDTO objDto) {
		Cliente cliente = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(),
				TipoCliente.toEnum(objDto.getTipoCliente()), pe.encode(objDto.getSenha()));
		
		Optional<Cidade> codCidade = cidadeRepository.findById(objDto.getCidadeId());
		
		Endereco endereco = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(),
				objDto.getBairro(), objDto.getCep(), cliente, codCidade.get());

		cliente.getEnderecos().add(endereco);
		cliente.getTelefones().add(objDto.getTelefone1());
		
		if(objDto.getTelefone2() != null) {
			cliente.getTelefones().add(objDto.getTelefone2());
		}
		
		if(objDto.getTelefone3() != null) {
			cliente.getTelefones().add(objDto.getTelefone3());
		}
		
		return cliente;
	}

	private void updateData(Cliente newObjt, Cliente obj) {
		newObjt.setNome(obj.getNome());
		newObjt.setEmail(obj.getEmail());
	}
}
