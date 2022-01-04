package br.com.mtonon.sysclientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.mtonon.sysclientes.domain.Cliente;
import br.com.mtonon.sysclientes.dto.ClienteDTO;
import br.com.mtonon.sysclientes.dto.ClienteNewDTO;
import br.com.mtonon.sysclientes.repository.ClienteRepository;
import br.com.mtonon.sysclientes.service.exceptions.DataIntegrityException;
import br.com.mtonon.sysclientes.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente findById(Long id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo:" + Cliente.class.getName()));
	}
	
	public Cliente findByNome(String nome) {
		Optional<Cliente> obj = repo.findByNome(nome);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Nome: " + nome + ", Tipo:" + Cliente.class.getName()));
	}
	
	public Cliente findByCpf(String cpf) {
		Optional<Cliente> obj = repo.findByCpf(cpf);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! CPF: " + cpf + ", Tipo:" + Cliente.class.getName()));
	}
	
	public List<Cliente> listAll() {
		List<Cliente> list = repo.findAll();
		return list;
	}
	
	public Page<Cliente> findByPage(Integer page, Integer linesPerPage, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Cliente save(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Long id) {
		findById(id);
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir um Cliente que esteja sendo usado por outra tabela!"
					);
		}
	}
	
	public Cliente fromDTO(ClienteDTO objDTO) {
		Cliente obj = new Cliente(objDTO.getId(), objDTO.getNome(), objDTO.getCpf());
		obj.setTelefone1(objDTO.getTelefone1());
		if(objDTO.getTelefone2() != null) {
			obj.setTelefone2(objDTO.getTelefone2());
		}
		if(objDTO.getTelefone3() != null) {
			obj.setTelefone3(objDTO.getTelefone3());
		}
		return obj;
	}

	
	public Cliente fromDTO(ClienteNewDTO objDTO) {
		Cliente obj = new Cliente(null, objDTO.getNome(), objDTO.getCpf());
		obj.setTelefone1(objDTO.getTelefone1());
		if(objDTO.getTelefone2() != null) {
			obj.setTelefone2(objDTO.getTelefone2());
		}
		if(objDTO.getTelefone3() != null) {
			obj.setTelefone3(objDTO.getTelefone3());
		}
		return obj;
	}
	

	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setId(obj.getId());
		newObj.setNome(obj.getNome());
		newObj.setTelefone1(obj.getTelefone1());
		newObj.setTelefone2(obj.getTelefone2());
		newObj.setTelefone3(obj.getTelefone3());
	}

}
