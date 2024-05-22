package com.bytelanches.aplicacao.porta.out.persistencia;

import com.bytelanches.aplicacao.dominio.pedido.Combo;
import com.bytelanches.aplicacao.dominio.pedido.IdentificadorDoPedido;
import com.bytelanches.aplicacao.dominio.pedido.Pedido;

import java.util.Optional;

public interface PedidoRepositorio {

	Optional<Combo> buscarCombo(IdentificadorDoPedido identificador);

	Optional<Pedido> buscarPedido(IdentificadorDoPedido identificador);

	void salvar(Combo combo);

	void salvar(Pedido pedido);

}
