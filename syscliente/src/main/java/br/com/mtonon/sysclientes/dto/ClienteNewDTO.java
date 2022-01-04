package br.com.mtonon.sysclientes.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

public class ClienteNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
		
	@NotBlank(message = "O campo Nome do cliente é obrigatório!")
	private String nome;
	
	@CPF(message = "O CPF informado não é válido!")
	private String cpf;
	
	@NotBlank(message = "O campo Telefone do cliente é obrigatório!")
	private String telefone1;
	
	private String telefone2;
	
	private String telefone3;
	
	public ClienteNewDTO() {
	}

	public ClienteNewDTO(String nome, String cpf, String telefone1, String telefone2,
			String telefone3) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.telefone3 = telefone3;
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
