package com.bytelanches.aplicacao.dominio.cliente;

import java.io.Serial;

public class CPFInvalido extends RuntimeException {
	@Serial
	private static final long serialVersionUID = 1L;

	public CPFInvalido(String mensagem) {
		super(mensagem);
	}

}
