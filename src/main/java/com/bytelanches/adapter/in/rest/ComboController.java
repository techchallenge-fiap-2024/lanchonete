package com.bytelanches.adapter.in.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import com.bytelanches.adapter.in.rest.dto.ComboVIewDTO;
import com.bytelanches.adapter.in.rest.dto.IdentificadorDoClienteViewDTO;
import com.bytelanches.aplicacao.dominio.cliente.CPF;
import com.bytelanches.aplicacao.dominio.cliente.Cliente;
import com.bytelanches.aplicacao.dominio.cliente.IdentificadorDoCliente;
import com.bytelanches.aplicacao.porta.in.cliente.BuscarClienteUseCase;
import com.bytelanches.aplicacao.porta.in.pedido.CriarComboUseCase;
import com.bytelanches.aplicacao.service.ClienteService;
import com.bytelanches.aplicacao.service.ComboService;

import java.util.Optional;

@Path("/combo")
@Produces(MediaType.APPLICATION_JSON)
public class ComboController extends AbstractController {

	private BuscarClienteUseCase buscarClienteUseCase;
	private CriarComboUseCase criarComboUseCase;

	ComboController() {
	}
	public ComboController(ClienteService clienteService, ComboService comboService) {
		this.buscarClienteUseCase = clienteService;
		this.criarComboUseCase = comboService;
	}

	@POST
	@Path("/")
	public ComboVIewDTO criar(IdentificadorDoClienteViewDTO identificadorDoClienteWebModel) {

		IdentificadorDoCliente identificadorDoCliente;
		if (identificadorDoClienteWebModel.cpf() != null) {
			CPF cpf = CPF.parse(identificadorDoClienteWebModel.cpf());
			if (cpf.isNull())
				throw badRequest("CPF inválido");

			identificadorDoCliente = IdentificadorDoCliente.cpf(identificadorDoClienteWebModel.nome(), cpf);
		} else
		if (identificadorDoClienteWebModel.nome() != null) {
			identificadorDoCliente = IdentificadorDoCliente.nome(identificadorDoClienteWebModel.nome());
		} else
			identificadorDoCliente = IdentificadorDoCliente.anonimo();

		Optional<Cliente> optional = Optional.empty();
		try {
			optional = buscarClienteUseCase.get(identificadorDoCliente);
			if (optional.isPresent()) {
				return ComboVIewDTO.fromDominio(criarComboUseCase.criar(optional.get()));
			}
		} catch (Exception e) {
			throw badRequest("Ocorreu um erro");
		}

		return ComboVIewDTO.fromDominio(criarComboUseCase.criar(identificadorDoCliente));
	}

	
}
