package com.bytelanches.aplicacao.dominio.pedido;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class IdentificadorDoPedido {
	public static final IdentificadorDoPedido NULL = new IdentificadorDoPedido();
	private final String codigo;
	private final LocalDate data;

	private IdentificadorDoPedido(String codigo, LocalDate data) {
		this.codigo = codigo;
		this.data = data;
	}
	private IdentificadorDoPedido(String codigo) {
		this.codigo = codigo;
		this.data = LocalDate.now();
	}
	private IdentificadorDoPedido() {
		this.codigo = "";
		this.data = LocalDate.now();
	}


	public static IdentificadorDoPedido nome(String nome) {
		return new IdentificadorDoPedido(nome);
	}

	public static IdentificadorDoPedido uuid() {
		return new IdentificadorDoPedido(UUID.randomUUID().toString());
	}


	public String getCodigo() {
		return codigo;
	}

	public LocalDate getData() {
		return data;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof IdentificadorDoPedido that)) return false;
        return Objects.equals(getCodigo(), that.getCodigo()) && Objects.equals(getData(), that.getData());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCodigo(), getData());
	}

	@Override
	public String toString() {
		return codigo;
	}
	
}
