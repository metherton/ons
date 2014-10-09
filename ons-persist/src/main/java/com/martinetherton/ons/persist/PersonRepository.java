package com.martinetherton.ons.persist;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.model.Surname;


public interface PersonRepository {

    Person findBy(long id);

    void setEntityManager(EntityManager entityManager);

    void populateCache();

    Map<Long, Person> getPersonCache();

    void clearCache();

    Person add(Person newPerson);

    Person findEarliestPerson();

    List<Person> findAll();

	List<Person> findBy(Surname surname);

}
