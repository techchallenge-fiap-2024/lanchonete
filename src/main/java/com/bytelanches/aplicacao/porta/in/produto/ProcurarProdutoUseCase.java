package com.bytelanches.aplicacao.porta.in.produto;

import java.util.Collection;

import com.bytelanches.aplicacao.dominio.produto.Produto;
import com.bytelanches.aplicacao.dominio.produto.TipoDeProduto;

public interface ProcurarProdutoUseCase {

	Collection<Produto> buscar(TipoDeProduto tipo);

	void salvar(Produto produto);

}
