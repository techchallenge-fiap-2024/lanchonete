package lanchonete.aplicacao.porta.out.persistencia;

import lanchonete.aplicacao.dominio.cliente.Cliente;
import lanchonete.aplicacao.dominio.pedido.Combo;
import lanchonete.aplicacao.dominio.pedido.IdentificadorDoPedido;
import lanchonete.aplicacao.dominio.pedido.Pedido;

import java.util.Optional;

public interface PedidoRepositorio {

	Optional<Combo> buscarCombo(IdentificadorDoPedido identificador);

	Optional<Pedido> buscarPedido(IdentificadorDoPedido identificador);

	void salvar(Combo combo);

	void salvar(Pedido pedido);

}
