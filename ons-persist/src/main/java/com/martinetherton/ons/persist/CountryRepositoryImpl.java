package com.martinetherton.ons.persist;

import com.martinetherton.ons.model.Country;
import com.martinetherton.ons.model.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CountryRepositoryImpl implements CountryRepository {

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

    @Override
    public List<Country> findAll() {
        Query query = entityManager.createQuery("select c from Country c");
        List<Country> countries = query.getResultList();
        return countries;
    }
}
