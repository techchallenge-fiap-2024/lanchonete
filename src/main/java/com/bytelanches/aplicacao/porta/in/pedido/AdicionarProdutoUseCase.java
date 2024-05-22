package com.bytelanches.aplicacao.porta.in.pedido;

import com.bytelanches.aplicacao.dominio.pedido.Combo;
import com.bytelanches.aplicacao.dominio.produto.Produto;

public interface AdicionarProdutoUseCase {

	void adicionar(Combo combo, Produto produto);
	
}
