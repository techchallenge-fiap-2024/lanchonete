package lanchonete.aplicacao.service;

import lanchonete.aplicacao.dominio.cliente.CPF;
import lanchonete.aplicacao.dominio.cliente.Cliente;
import lanchonete.aplicacao.dominio.cliente.ClienteIdentificadoComCPF;
import lanchonete.aplicacao.dominio.cliente.IdentificadorDoCliente;
import lanchonete.aplicacao.dominio.pedido.Combo;
import lanchonete.aplicacao.porta.in.cliente.BuscarClienteUseCase;
import lanchonete.aplicacao.porta.in.pedido.CriarComboUseCase;
import lanchonete.aplicacao.porta.out.persistencia.ClienteRepositorio;
import lanchonete.aplicacao.porta.out.persistencia.PedidoRepositorio;

import java.util.Optional;

public class ComboService implements CriarComboUseCase {

	private final BuscarClienteUseCase buscarClienteUseCase;
	private final PedidoRepositorio pedidoRepositorio;

	public ComboService(BuscarClienteUseCase buscarClienteUseCase, PedidoRepositorio pedidoRepositorio) {
		this.buscarClienteUseCase = buscarClienteUseCase;
		this.pedidoRepositorio = pedidoRepositorio;
	}


	@Override
	public Combo criar(Cliente cliente) {
		Combo combo = new Combo();
		combo.setClienteId(cliente.getId());

		pedidoRepositorio.salvar(combo);
		return combo;
	}

	@Override
	public Combo criar(IdentificadorDoCliente identificadorDoCliente) {
		if (identificadorDoCliente instanceof ClienteIdentificadoComCPF c) {
			Optional<Cliente> optional = buscarClienteUseCase.get(c.getCpf());
			if (optional.isPresent())
				return criar(optional.get());
		}

		Combo combo = new Combo();
		combo.setIdentificadorDoCliente(identificadorDoCliente.getIdentificador());

		pedidoRepositorio.salvar(combo);
		return combo;
	}


}
