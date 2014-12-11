package com.martinetherton.ons.persist;

import com.martinetherton.ons.model.CensusHousehold;
import com.martinetherton.ons.model.CensusHouseholdEntry;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by martin on 11/12/14.
 */
@Repository
public class CensusHouseholdEntryRepositoryImpl implements CensusHouseholdEntryRepository {

    private EntityManager entityManager;

    @Override
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<CensusHouseholdEntry> findAll() {
        Query query = entityManager.createQuery("select c from CensusHouseholdEntry c");
        List<CensusHouseholdEntry> censusHouseholdEntries = query.getResultList();
        return censusHouseholdEntries;
    }
}
