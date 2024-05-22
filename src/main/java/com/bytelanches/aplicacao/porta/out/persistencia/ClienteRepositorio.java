package com.bytelanches.aplicacao.porta.out.persistencia;

import java.util.Optional;

import com.bytelanches.aplicacao.dominio.cliente.CPF;
import com.bytelanches.aplicacao.dominio.cliente.Cliente;

public interface ClienteRepositorio {

	Optional<Cliente> get(CPF cpf);

	Optional<Integer> getId(CPF cpf);

	void salvar(Cliente cliente);

}
