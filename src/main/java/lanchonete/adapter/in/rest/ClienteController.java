package lanchonete.adapter.in.rest;

import java.util.Optional;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lanchonete.adapter.in.rest.dto.ClienteViewDTO;
import lanchonete.aplicacao.dominio.cliente.CPF;
import lanchonete.aplicacao.dominio.cliente.CPFInvalido;
import lanchonete.aplicacao.dominio.cliente.Cliente;
import lanchonete.aplicacao.dominio.cliente.IdentificadorDoCliente;
import lanchonete.aplicacao.porta.in.cliente.BuscarClienteUseCase;
import lanchonete.aplicacao.porta.in.cliente.CadastrarClienteUseCase;
import lanchonete.aplicacao.service.ClienteService;
import lanchonete.aplicacao.service.JaExisteUmClienteComEsseCPF;

@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON)
public class ClienteController extends AbstractController {

	private BuscarClienteUseCase buscarClienteUseCase;
	private CadastrarClienteUseCase cadastrarClienteUseCase;

	ClienteController() {
	}
	public ClienteController(ClienteService clienteService) {
		this.buscarClienteUseCase = clienteService;
		this.cadastrarClienteUseCase = clienteService;
	}

	@GET
	@Path("/buscar/{cpf}")
	public Response buscar(@PathParam("cpf") String cpfString) {
		CPF cpf = CPF.parse(cpfString);
		if (cpf.isNull())
			throw badRequest("CPF inválido");

		Optional<Cliente> optional = Optional.empty();
		try {
			optional = buscarClienteUseCase.get(cpf);
		} catch (Exception e) {
			throw badRequest("Ocorreu um erro");
		}

		if (optional.isEmpty())
			return notExist();

		return Response.ok(ClienteViewDTO.fromDominio(optional.get())).build();
	}


	@POST
	@Path("/")
	public Response cadastrar(
//			ClienteWebModel model
			String requestJson
	) {

		ClienteViewDTO model = null;
		try {
			model = lerJson(requestJson, ClienteViewDTO.class);
		} catch (Exception e) {
			throw badRequest("Erro ao ler json");
		}

		if (model.getCpf() != null) {
			CPF cpf = CPF.NULL;
			try {
				cpf = CPF.of(model.getCpf());
			} catch (CPFInvalido e) {
				throw badRequest("CPF informado é inválido: " + e.getMessage());
			}

			Cliente cliente = null;
			try {
				cliente = cadastrarClienteUseCase.cadastrar(cpf, model.getNome(), model.getEmail());
			} catch (JaExisteUmClienteComEsseCPF e) {
				throw badRequest("Já existe um cliente com esse cpf");
			}
			IdentificadorDoCliente id = IdentificadorDoCliente.cpf(cliente.getNome(), cliente.getCpf());
			return Response.ok(id).build();
		}

		IdentificadorDoCliente id = IdentificadorDoCliente.nome(model.getNome());
		return Response.ok(id).build();
	}

	@POST
	@Path("/anonimo")
	public Response anonimo() {
		IdentificadorDoCliente id = IdentificadorDoCliente.anonimo();
		return Response.ok(id).build();
	}

}