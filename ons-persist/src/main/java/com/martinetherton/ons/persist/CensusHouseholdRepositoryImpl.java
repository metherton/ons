package com.martinetherton.ons.persist;


import com.martinetherton.ons.model.Census;
import com.martinetherton.ons.model.CensusHousehold;
import com.martinetherton.ons.model.Location;
import com.martinetherton.ons.model.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by martin on 11/12/14.
 */
@Repository
public class CensusHouseholdRepositoryImpl implements CensusHouseholdRepository {

    private EntityManager entityManager;

    @Override
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<CensusHousehold> findAll() {
        Query query = entityManager.createQuery("select c from CensusHousehold c");
        List<CensusHousehold> censusHouseholds = query.getResultList();
        return censusHouseholds;
    }

    @Override
    public CensusHousehold findCensusHousehold(Census census, Location location) {
        Query query = entityManager.createQuery("select c from CensusHousehold c where c.census = :census and c.location = :location");
        query.setParameter("census", census);
        query.setParameter("location", location);
        try {
            return (CensusHousehold) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public CensusHousehold add(CensusHousehold censusHousehold) {
        entityManager.persist(censusHousehold);
        return censusHousehold;
    }

}
