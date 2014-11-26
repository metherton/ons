package com.martinetherton.ons.persist;

import javax.persistence.EntityManager;

import com.martinetherton.ons.model.Location;
import com.martinetherton.ons.model.Surname;

import java.util.List;

public interface LocationRepository {

    void setEntityManager(EntityManager entityManager);

    Location findBy(long id);
    public List<Location> findAll();

}
