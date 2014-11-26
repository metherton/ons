package com.martinetherton.ons.persist;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.martinetherton.ons.model.Person;
import org.springframework.stereotype.Repository;

import com.martinetherton.ons.model.Location;

import java.util.List;

@Repository
public class LocationRepositoryImpl implements LocationRepository {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Location findBy(long id) {
        return entityManager.find(Location.class, id);
    }

    @Override
    public List<Location> findAll() {
        Query query = entityManager.createQuery("select l from Location l");
        List<Location> locations = query.getResultList();
        return locations;
    }

}
