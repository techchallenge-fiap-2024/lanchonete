package lanchonete.aplicacao.porta.in.pedido;

import lanchonete.aplicacao.dominio.pedido.Combo;
import lanchonete.aplicacao.dominio.produto.Produto;

public interface AlterarProdutoUseCase {

	void alterar(Combo combo, Produto produto);
	
}
