package com.bytelanches.aplicacao.service;

import com.bytelanches.aplicacao.dominio.cliente.Cliente;
import com.bytelanches.aplicacao.dominio.cliente.ClienteIdentificadoComCPF;
import com.bytelanches.aplicacao.dominio.cliente.IdentificadorDoCliente;
import com.bytelanches.aplicacao.dominio.pedido.Combo;
import com.bytelanches.aplicacao.porta.in.cliente.BuscarClienteUseCase;
import com.bytelanches.aplicacao.porta.in.pedido.CriarComboUseCase;
import com.bytelanches.aplicacao.porta.out.persistencia.PedidoRepositorio;

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
