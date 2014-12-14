package com.martinetherton.ons.persist;

import com.martinetherton.ons.model.CensusHousehold;
import com.martinetherton.ons.model.CensusHouseholdEntry;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by martin on 11/12/14.
 */
public interface CensusHouseholdEntryRepository {

    void setEntityManager(EntityManager entityManager);

    List<CensusHouseholdEntry> findAll();

    List<CensusHouseholdEntry> findAllEntriesFor(Long year);
}
