package lanchonete.aplicacao.porta.in.pagamento;

import lanchonete.aplicacao.dominio.pedido.Combo;
import lanchonete.aplicacao.dominio.pedido.Pedido;
import lanchonete.aplicacao.dominio.produto.Produto;

public interface PagarUseCase {

	Pedido pagar(Combo combo);
	
}
