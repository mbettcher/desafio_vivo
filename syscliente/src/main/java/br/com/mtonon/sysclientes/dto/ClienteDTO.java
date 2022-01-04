package br.com.mtonon.sysclientes.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.mtonon.sysclientes.domain.Cliente;

public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "O campo Id do cliente é obrigatório!")
	private Long id;
	
	@NotBlank(message = "O campo Nome do cliente é obrigatório!")
	private String nome;
	
	@CPF(message = "O CPF informado não é válido!")
	private String cpf;

	@NotBlank(message = "O campo Telefone do cliente é obrigatório!")
	private String telefone1;
	
	private String telefone2;
	
	private String telefone3;

	public ClienteDTO() {
	}
	
	public ClienteDTO(Cliente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.telefone1 = obj.getTelefone1();
		this.telefone2 = obj.getTelefone2();
		this.telefone3 = obj.getTelefone3();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}


	
}
