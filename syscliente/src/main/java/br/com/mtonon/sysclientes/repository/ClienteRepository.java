package br.com.mtonon.sysclientes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mtonon.sysclientes.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Optional<Cliente> findByNome(String nome);
	
	Optional<Cliente> findByCpf(String cpf);

}
