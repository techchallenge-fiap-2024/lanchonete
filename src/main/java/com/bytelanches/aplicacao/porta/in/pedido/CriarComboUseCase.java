package com.bytelanches.aplicacao.porta.in.pedido;

import com.bytelanches.aplicacao.dominio.cliente.Cliente;
import com.bytelanches.aplicacao.dominio.cliente.IdentificadorDoCliente;
import com.bytelanches.aplicacao.dominio.pedido.Combo;

public interface CriarComboUseCase {

	Combo criar(Cliente cliente);

	Combo criar(IdentificadorDoCliente identificadorDoCliente);
	
}
