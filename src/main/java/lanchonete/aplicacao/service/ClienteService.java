package lanchonete.aplicacao.service;

import java.util.Optional;

import lanchonete.aplicacao.dominio.cliente.CPF;
import lanchonete.aplicacao.dominio.cliente.Cliente;
import lanchonete.aplicacao.porta.in.cliente.BuscarClienteUseCase;
import lanchonete.aplicacao.porta.in.cliente.CadastrarClienteUseCase;
import lanchonete.aplicacao.porta.out.persistencia.ClienteRepositorio;

public class ClienteService implements BuscarClienteUseCase, CadastrarClienteUseCase {

	private ClienteRepositorio clienteRepositorio;
	
	public ClienteService(ClienteRepositorio clienteRepositorio) {
		this.clienteRepositorio = clienteRepositorio;
	}
	


	@Override
	public Optional<Cliente> get(CPF cpf) {
	    if (cpf.isNull())
	    	return Optional.empty();
	    return clienteRepositorio.get(cpf);
	}

	@Override
	public Optional<Integer> getId(CPF cpf) {
		if (cpf.isNull())
			return Optional.empty();
		return clienteRepositorio.getId(cpf);
	}


	@Override
	public Cliente cadastrar(CPF cpf, String nome, String email) {
		if (cpf.isNull())
			throw new IllegalArgumentException("Obrigatório cpf para cadastrar ciente");

		Cliente cliente = new Cliente(cpf, nome, email);
		clienteRepositorio.salvar(cliente);
		return cliente;
	}
}
