package com.bytelanches.bootstrap;

import java.util.Set;

import jakarta.persistence.EntityManagerFactory;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import com.bytelanches.adapter.in.rest.ClienteController;
import com.bytelanches.adapter.out.persistencia.jpa.ClienteRepositorioJpa;
import com.bytelanches.adapter.out.persistencia.jpa.EntityManagerFactoryFactory;
import com.bytelanches.adapter.out.persistencia.memoria.ClienteRepositorioMemoria;
import com.bytelanches.aplicacao.porta.out.persistencia.ClienteRepositorio;
import com.bytelanches.aplicacao.service.ClienteService;

@ApplicationPath("/")
public class RestApplication extends Application {

	private ClienteRepositorio clienteRepositorio;

	@Override
	public Set<Object> getSingletons() {
		initPersistenceAdapters();
		return Set.of(clienteController());
	}

	private void initPersistenceAdapters() {
		String persistencia = System.getProperty("mysql", "memoria");
		persistencia = "memoria";
		
		switch (persistencia) {
		case "memoria" -> initInMemoryAdapters();
		case "mysql" -> initMySqlAdapters();
		default -> throw new IllegalArgumentException("Valor informado para tipo de persistencia inválido: '%s' (valores válidos: 'memória', 'mysql')".formatted(persistencia));
		}
	}

	private void initInMemoryAdapters() {
		clienteRepositorio = new ClienteRepositorioMemoria();
	}

	// The EntityManagerFactory doesn't need to get closed before the application is
	// stopped
	private void initMySqlAdapters() {
		EntityManagerFactory entityManagerFactory = EntityManagerFactoryFactory.createMySqlEntityManagerFactory(
				"jdbc:mysql://localhost:3306/shop", "root", "test");

		clienteRepositorio = new ClienteRepositorioJpa(entityManagerFactory);
	}

	private ClienteController clienteController() {
		ClienteService clienteService = new ClienteService(clienteRepositorio);
		return new ClienteController(clienteService);
	}

}
