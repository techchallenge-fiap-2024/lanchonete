package com.bytelanches.aplicacao.porta.in.pagamento;

import com.bytelanches.aplicacao.dominio.pedido.Combo;
import com.bytelanches.aplicacao.dominio.pedido.Pedido;

public interface PagarUseCase {

	Pedido pagar(Combo combo);
	
}
