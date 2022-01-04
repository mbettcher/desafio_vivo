package br.com.mtonon.sysclientes.recource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mtonon.sysclientes.domain.Cliente;
import br.com.mtonon.sysclientes.dto.ClienteDTO;
import br.com.mtonon.sysclientes.dto.ClienteNewDTO;
import br.com.mtonon.sysclientes.service.ClienteService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDTO>> listAll(){
		List<Cliente> list = clienteService.listAll();
		List<ClienteDTO> listDTO = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ClienteDTO>> listPage(
			@RequestParam(value = "page", defaultValue = "0")  Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy){
		Page<Cliente> list = clienteService.findByPage(page, linesPerPage, direction, orderBy);
		Page<ClienteDTO> listDTO = list.map(obj -> new ClienteDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/codigo/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Cliente obj = clienteService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

	@RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> findByName(@PathVariable String nome) {
		Cliente obj = clienteService.findByNome(nome);
		return ResponseEntity.ok().body(obj);
	}
	

	@RequestMapping(value = "/cpf/{cpf}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> findByCpf(@PathVariable String cpf) {
		Cliente obj = clienteService.findByCpf(cpf);
		return ResponseEntity.ok().body(obj);
	}


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteNewDTO objDTO){
		Cliente obj = clienteService.fromDTO(objDTO);
		obj = clienteService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Cliente> update(@PathVariable Long id , @RequestBody ClienteDTO objDTO) {
		Cliente obj = clienteService.fromDTO(objDTO);
		obj = clienteService.update(obj);
		return ResponseEntity.ok().build();
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clienteService.delete(id);
		return ResponseEntity.ok().build();
	}
}
