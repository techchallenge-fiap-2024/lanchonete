package lanchonete.aplicacao.dominio.cliente;

import java.util.UUID;

public final class ClienteAnonimo extends IdentificadorDoCliente {

	ClienteAnonimo() {
		super(UUID.randomUUID().toString());
	}

}