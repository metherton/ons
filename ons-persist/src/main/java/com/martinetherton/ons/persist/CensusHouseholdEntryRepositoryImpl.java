package com.martinetherton.ons.persist;

import com.martinetherton.ons.model.CensusHousehold;
import com.martinetherton.ons.model.CensusHouseholdEntry;
import com.martinetherton.ons.model.Person;
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
    public CensusHouseholdEntry findBy(long id) {
        return entityManager.find(CensusHouseholdEntry.class, id);
    }

    @Override
    public List<CensusHouseholdEntry> findAll() {
        Query query = entityManager.createQuery("select c from CensusHouseholdEntry c");
        List<CensusHouseholdEntry> censusHouseholdEntries = query.getResultList();
        return censusHouseholdEntries;
    }

    @Override
    public List<CensusHouseholdEntry> findAllEntriesFor(Long year) {
        Query query = entityManager.createQuery("select c from CensusHouseholdEntry c  JOIN c.censusHousehold b " +
                                                "JOIN b.census a JOIN c.person WHERE a.year = :year");
        query.setParameter("year", year);
        List<CensusHouseholdEntry> censusHouseholdEntries = query.getResultList();
        return censusHouseholdEntries;
    }

    @Override
    public CensusHouseholdEntry add(CensusHouseholdEntry censusHouseholdEntry) {
        entityManager.persist(censusHouseholdEntry);
        return censusHouseholdEntry;
    }
}
