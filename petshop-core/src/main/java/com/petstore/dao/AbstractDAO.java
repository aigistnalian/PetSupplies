package com.petstore.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.petstore.dao.DAO;
/**
 * Abstract base DAO class
 * Holds base methods required by all dao classes
 * extending this base class.
 * 
 * @author analian
 *
 * @param <K>
 * @param <E>
 */
public abstract class AbstractDAO<K, E> implements DAO<K, E> {

	/**
	 * The main persistence unit named admin
	 * being used by JPA through EntityManager class.
	 */
	@PersistenceContext(name="admin",type=PersistenceContextType.EXTENDED)
	protected EntityManager entityManager;
	
	/**
	 * The class being used by entity manager to persist/merge/remove
	 */
	protected Class<E> entityClass;
 
	/**
	 * Constructor
	 */
	@SuppressWarnings("unchecked")
	public AbstractDAO() 
	{
		ParameterizedType genericSuperclass = 
				(ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = 
				(Class<E>) genericSuperclass.getActualTypeArguments()[1];
	}
 
	/* (non-Javadoc)
	 * @see com.petstore.dao.DAO#persist(java.lang.Object)
	 */
	public void persist(E entity) 
	{ 
		entityManager.persist(entity); 
	}
 
	/* (non-Javadoc)
	 * @see com.petstore.dao.DAO#remove(java.lang.Object)
	 */
	public void remove(E entity)
	{ 
		entityManager.remove(entity); 
	}
 
	/* (non-Javadoc)
	 * @see com.petstore.dao.DAO#findById(java.lang.Object)
	 */
	public E findById(K id)
	{ 
		return entityManager.find(entityClass, id); 
	}
	
	

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() 
	{
		return entityManager;
	}

	/**
	 * @param entityManager the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) 
	{
		this.entityManager = entityManager;
	}

	/**
	 * @return the entityClass
	 */
	public Class<E> getEntityClass() 
	{
		return entityClass;
	}

	/**
	 * @param entityClass the entityClass to set
	 */
	public void setEntityClass(Class<E> entityClass) 
	{
		this.entityClass = entityClass;
	}
}
