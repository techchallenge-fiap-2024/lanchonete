package com.bytelanches.adapter.out.persistencia.memoria;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.bytelanches.aplicacao.dominio.produto.Produto;
import com.bytelanches.aplicacao.dominio.produto.TipoDeProduto;
import com.bytelanches.aplicacao.porta.out.persistencia.ProdutoRepositorio;

public class ProdutoRepositorioMemoria implements ProdutoRepositorio {

	private Map<Integer, Produto> produtos;

	public ProdutoRepositorioMemoria() {
		this.produtos = new HashMap<>();
	}


	@Override
	public Collection<Produto> buscar(TipoDeProduto tipo) {
		return produtos.entrySet().stream()
			.map(i -> i.getValue())
			.filter(p -> tipo.equals(p.getTipo()))
			.collect(Collectors.toSet());
	}

	@Override
	public Collection<Produto> buscar() {
		return produtos.entrySet().stream()
			.map(i -> i.getValue())
			.collect(Collectors.toSet());
	}


	@Override
	public void salvar(Produto produto) {
		produtos.put(produto.getId(), produto);
	}

}
