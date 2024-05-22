package com.bytelanches.adapter.out.persistencia.jpa;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import com.bytelanches.aplicacao.dominio.produto.Produto;
import com.bytelanches.aplicacao.dominio.produto.TipoDeProduto;
import com.bytelanches.aplicacao.porta.out.persistencia.ProdutoRepositorio;

public class ProdutoRepositorioJpa implements ProdutoRepositorio {

	private EntityManagerFactory entityManagerFactory;

	public ProdutoRepositorioJpa(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}


	@Override
	public Collection<Produto> buscar(TipoDeProduto tipo) {
		try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
			Query query = entityManager.createNativeQuery("""
					SELECT *
					FROM produto
					WHERE 1 = 1
					  AND tipo =:tipo
					""", ProdutoJpaEntity.class)
					.setParameter("tipo", tipo.toString());
			try {
				List result = query.getResultList();
				return ProdutoMapper.toModelEntities(result);
			} catch (Exception e) {
				return Collections.emptyList();
			}
		}
	}

	@Override
	public Collection<Produto> buscar() {
		try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
			Query query = entityManager.createNativeQuery("""
					SELECT *
					FROM produto
					WHERE 1 = 1
					""", ProdutoJpaEntity.class);
			try {
				List result = query.getResultList();
				return ProdutoMapper.toModelEntities(result);
			} catch (Exception e) {
				return Collections.emptyList();
			}
		}
	}


	@Override
	public void salvar(Produto produto) {
		try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
			entityManager.getTransaction().begin();
			entityManager.merge(ProdutoMapper.toJpaEntity(produto));
			entityManager.getTransaction().commit();
		}
	}

}
