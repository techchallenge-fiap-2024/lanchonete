package lanchonete.aplicacao.porta.in.pedido;

import lanchonete.aplicacao.dominio.pedido.Combo;
import lanchonete.aplicacao.dominio.produto.Produto;

public interface AdicionarProdutoUseCase {

	void adicionar(Combo combo, Produto produto);
	
}
