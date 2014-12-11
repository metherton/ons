package com.martinetherton.ons.persist;

import com.martinetherton.ons.model.Census;
import com.martinetherton.ons.model.CensusHousehold;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by martin on 11/12/14.
 */
public interface CensusHouseholdRepository {

    void setEntityManager(EntityManager entityManager);

    List<CensusHousehold> findAll();
}
