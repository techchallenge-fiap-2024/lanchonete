package lanchonete.adapter.in.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lanchonete.adapter.in.rest.dto.ComboVIewDTO;
import lanchonete.adapter.in.rest.dto.IdentificadorDoClienteViewDTO;
import lanchonete.aplicacao.dominio.cliente.CPF;
import lanchonete.aplicacao.dominio.cliente.Cliente;
import lanchonete.aplicacao.dominio.cliente.IdentificadorDoCliente;
import lanchonete.aplicacao.porta.in.cliente.BuscarClienteUseCase;
import lanchonete.aplicacao.porta.in.pedido.CriarComboUseCase;
import lanchonete.aplicacao.service.ClienteService;
import lanchonete.aplicacao.service.ComboService;

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
