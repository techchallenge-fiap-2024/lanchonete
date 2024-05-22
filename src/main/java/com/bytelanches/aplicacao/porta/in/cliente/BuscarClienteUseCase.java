package com.bytelanches.aplicacao.porta.in.cliente;

import java.util.Optional;

import com.bytelanches.aplicacao.dominio.cliente.*;
import lanchonete.aplicacao.dominio.cliente.*;

public interface BuscarClienteUseCase {

	Optional<Cliente> get(CPF cpf);

	Optional<Integer> getId(CPF cpf);

	default Optional<Cliente> get(IdentificadorDoCliente identificadorDoCliente) {
        if (identificadorDoCliente instanceof ClienteIdentificadoComNome n)
            return Optional.empty();

		if (identificadorDoCliente instanceof ClienteAnonimo c)
            return Optional.empty();

		if (identificadorDoCliente instanceof ClienteIdentificadoComCPF c)
			return get(c.getCpf());

		return Optional.empty();
	}

	default Optional<Integer> getId(IdentificadorDoCliente identificadorDoCliente) {
		if (identificadorDoCliente instanceof ClienteIdentificadoComNome n)
			return Optional.empty();

		if (identificadorDoCliente instanceof ClienteAnonimo c)
			return Optional.empty();

		if (identificadorDoCliente instanceof ClienteIdentificadoComCPF c)
			return getId(c.getCpf());

		return Optional.empty();
	}

}
