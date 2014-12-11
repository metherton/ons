package com.martinetherton.ons.persist;

import com.martinetherton.ons.model.Census;
import com.martinetherton.ons.model.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by martin on 08/12/14.
 */
@Repository
public class CensusRepositoryImpl implements CensusRepository {

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
    public List<Census> findAll() {
        Query query = entityManager.createQuery("select c from Census c");
        List<Census> censuses = query.getResultList();
        return censuses;
    }
}
