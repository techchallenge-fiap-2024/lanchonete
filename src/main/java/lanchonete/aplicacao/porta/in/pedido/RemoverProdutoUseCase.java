package lanchonete.aplicacao.porta.in.pedido;

import lanchonete.aplicacao.dominio.pedido.Combo;
import lanchonete.aplicacao.dominio.produto.Produto;

public interface RemoverProdutoUseCase {

	void remover(Combo combo, Produto produto);
	
}
