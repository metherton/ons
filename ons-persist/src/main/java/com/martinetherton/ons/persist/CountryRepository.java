package com.martinetherton.ons.persist;

import com.martinetherton.ons.model.Country;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by martin on 26/11/14.
 */
public interface CountryRepository {

    public List<Country> findAll();

    void setEntityManager(EntityManager entityManager);

}
