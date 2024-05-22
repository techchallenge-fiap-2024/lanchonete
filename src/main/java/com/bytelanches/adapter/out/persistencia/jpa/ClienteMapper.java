package com.bytelanches.adapter.out.persistencia.jpa;

import java.util.List;
import java.util.Optional;

import com.bytelanches.aplicacao.dominio.cliente.Cliente;

class ClienteMapper {
	private ClienteMapper() {}

	static ClienteJpaEntity toJpaEntity(Cliente cliente) {
		ClienteJpaEntity jpaEntity = new ClienteJpaEntity(cliente.getCpf(), cliente.getNome(), cliente.getEmail());
		return jpaEntity;
	}

	static Optional<Cliente> toModelEntityOptional(ClienteJpaEntity jpaEntity) {
		return Optional.ofNullable(jpaEntity).map(ClienteMapper::toModelEntity);
	}

	static Cliente toModelEntity(ClienteJpaEntity jpaEntity) {
		return new Cliente(
				jpaEntity.getId(), 
				jpaEntity.getCpf(),
				jpaEntity.getNome(), 
				jpaEntity.getEmail());
	}

	static List<Cliente> toModelEntities(List<ClienteJpaEntity> jpaEntities) {
		return jpaEntities.stream().map(ClienteMapper::toModelEntity).toList();
	}
}
