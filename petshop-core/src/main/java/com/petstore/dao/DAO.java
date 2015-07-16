package com.petstore.dao;

/**
 * Base DAO Interface implemented by all
 * 
 * @author analian
 *
 * @param <K>
 * @param <E>
 */
public interface DAO<K, E> 
{
    /**
     * saving to DB
     * 
     * @param entity
     */
    void persist(E entity);
    /**
     * removing a selected entity
     * @param entity
     */
    void remove(E entity);
    
    /**
     * searching
     * 
     * @param id
     * @return
     */
    E findById(K id);
}
