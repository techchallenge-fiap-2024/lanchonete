package com.bytelanches.aplicacao.porta.in.pedido;

import com.bytelanches.aplicacao.dominio.pedido.Combo;
import com.bytelanches.aplicacao.dominio.pedido.Pedido;

public interface CriarPedidoUseCase {

	Pedido criar(Combo combo);
	
}
