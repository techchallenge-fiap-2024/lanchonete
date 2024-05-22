package com.bytelanches.aplicacao.dominio.cliente;

import java.util.Objects;

public sealed class IdentificadorDoCliente permits ClienteIdentificadoComNome, ClienteIdentificadoComCPF, ClienteAnonimo{
	private final String identificador;

	protected IdentificadorDoCliente(String identificador) {
		this.identificador = identificador;
	}


	public static IdentificadorDoCliente nome(String nome) {
		return new ClienteIdentificadoComNome(nome);
	}

	public static IdentificadorDoCliente cpf(String nome, CPF cpf) {
		if (cpf.isNull())
			return nome(nome);
		return new ClienteIdentificadoComCPF(nome, cpf);
	}

	public static IdentificadorDoCliente anonimo() {
		return new ClienteAnonimo();
	}

	public String getIdentificador() {
		return identificador;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof IdentificadorDoCliente that)) return false;
        return Objects.equals(getIdentificador(), that.getIdentificador());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getIdentificador());
	}

	@Override
	public String toString() {
		return identificador;
	}

}






