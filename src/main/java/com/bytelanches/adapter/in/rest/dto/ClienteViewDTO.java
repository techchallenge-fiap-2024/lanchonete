package com.bytelanches.adapter.in.rest.dto;

import com.bytelanches.aplicacao.dominio.cliente.Cliente;

public class ClienteViewDTO {

	private String cpf;
	private String nome;
	private String email;

	public ClienteViewDTO(){}
	ClienteViewDTO(String cpf, String nome, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}


	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public static ClienteViewDTO fromDominio(Cliente cliente) {
		return new ClienteViewDTO(cliente.getCpf().toString(), cliente.getNome(), cliente.getEmail());
	}
	
}
