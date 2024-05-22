package lanchonete.aplicacao.dominio.cliente;

import java.util.Objects;

public final class ClienteIdentificadoComCPF extends IdentificadorDoCliente {
	private final CPF cpf;

	ClienteIdentificadoComCPF(String nome, CPF cpf) {
		super(nome);
		this.cpf = cpf;
	}

	public CPF getCpf() {
		return cpf;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ClienteIdentificadoComCPF that)) return false;
		return Objects.equals(getCpf(), that.getCpf());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCpf());
	}
}