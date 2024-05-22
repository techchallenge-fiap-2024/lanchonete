package com.bytelanches.aplicacao.porta.out.persistencia;

import java.util.Collection;

import com.bytelanches.aplicacao.dominio.produto.Produto;
import com.bytelanches.aplicacao.dominio.produto.TipoDeProduto;

public interface ProdutoRepositorio {

	Collection<Produto> buscar(TipoDeProduto tipo);

	Collection<Produto> buscar();

	void salvar(Produto produto);
	
}
