package com.gustavo.curso.boot.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public abstract class AbstractDao<T, PK extends Serializable> {
	
	@SuppressWarnings("unchecked")
	//Atribui a entityClass o tipo da entidade que a operação que vem de um DAO está passando para 
	//AstractDAO (Ex: Cargo, Departamento e Funcionario)
	private final Class<T> entityClass = 
			(Class<T>) ( (ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	
	@PersistenceContext
	//EntityManager é o recurso responsável por realizar as operações de sincronismo com o banco de dados 
	//(inserir, remover, atualizar ou consultar - CRUD) e gerenciar o ciclo de vida das entidades.
	private EntityManager entityManager;
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void save(T entity) {
		entityManager.persist(entity);
	}
	
	public void update(T entity) {
		entityManager.merge(entity);
	}
	
	public void delete(PK id) {
		entityManager.remove(entityManager.getReference(entityClass, id));
	}
	
	public T findById(PK id) {
		return entityManager.find(entityClass, id);
	}
	
	public List<T> findAll() {
		return entityManager
				.createQuery("from " + entityClass.getSimpleName(), entityClass)
				.getResultList();		
	}
	
	protected List<T> createQuery(String jpql, Object... params){
		TypedQuery<T> query = entityManager.createQuery(jpql, entityClass);
		for(int i = 0; i < params.length; i++) {
			query.setParameter(i+1, params[i]);
		}
		return query.getResultList();
	}

}
