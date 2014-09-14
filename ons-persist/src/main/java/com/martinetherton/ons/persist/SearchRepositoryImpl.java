package com.martinetherton.ons.persist;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SearchRepositoryImpl implements SearchRepository {

	private EntityManager entityManager;
	
    /**
     * Set the entity manager. Assumes automatic dependency injection via the
     * JPA @PersistenceContext annotation. However this method may still be
     * called manually in a unit-test.
     * 
     * @param entityManager
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
