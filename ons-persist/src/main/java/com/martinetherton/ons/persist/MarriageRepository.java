package com.martinetherton.ons.persist;

import java.util.List;

import javax.persistence.EntityManager;

import com.martinetherton.ons.model.Location;
import com.martinetherton.ons.model.Marriage;
import com.martinetherton.ons.model.Person;

public interface MarriageRepository {

    void setEntityManager(EntityManager entityManager);

    Marriage findBy(long id);

	List<Marriage> findMarriagesFor(Person person);

}
