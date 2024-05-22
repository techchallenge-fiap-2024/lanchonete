package com.bytelanches.aplicacao.porta.in.cliente;

import com.bytelanches.aplicacao.dominio.cliente.CPF;
import com.bytelanches.aplicacao.dominio.cliente.Cliente;

public interface CadastrarClienteUseCase {

	Cliente cadastrar(CPF cpf, String nome, String email);
	
}
