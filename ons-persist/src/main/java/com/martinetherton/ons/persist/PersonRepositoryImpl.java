package com.martinetherton.ons.persist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.model.Surname;


@Repository
public class PersonRepositoryImpl implements PersonRepository, InitializingBean{
    
    private EntityManager entityManager;
    private Map<Long, Person> cache;
    
    @Override
    public Person findBy(long entityId) {
//        if (cache != null && cache.containsKey(entityId)) {
//            return cache.get(entityId);
//        }
        return entityManager.find(Person.class, entityId);
    }

    /**
     * Set the entity manager. Assumes automatic dependency injection via the
     * JPA @PersistenceContext annotation. However this method may still be
     * called manually in a unit-test.
     * 
     * @param entityManager
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostConstruct
    public void populateCache() {
        System.out.println("in populate cache");
        cache = new HashMap<Long, Person>();
        Query query = entityManager.createQuery("select p from Person p");
        List<Person> persons = query.getResultList();
        for (Person p : persons) {
            cache.put(p.getEntityId(), p);
        }
    }

    @PreDestroy
    public Map<Long, Person> getPersonCache() {
        return cache;
    }

    @Override
    public void clearCache() {
        cache.clear();
    }

    @Override
    public Person add(Person newPerson) {
        entityManager.persist(newPerson);
        return newPerson;
    }

    @Override
    public Person findEarliestPerson() {
  
        return null;
    }

    @Override
    public List<Person> findAll() {
        Query query = entityManager.createQuery("select p from Person p");
        List<Person> persons = query.getResultList();
        return persons;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("in after properties set");
    }

	@Override
	public List<Person> findBy(Surname surname) {
        Query query = entityManager.createQuery("select p from Person p where p.surname.surname = :surname");
        query.setParameter("surname", surname.getSurname());
        List<Person> persons = query.getResultList();
        return persons;
	}

	@Override
	public List<Person> findAllMalePersons() {
        Query query = entityManager.createQuery("select p from Person p where p.gender = 1");
        List<Person> persons = query.getResultList();
        return persons;
	}

	@Override
	public List<Person> findAllFemalePersons() {
        Query query = entityManager.createQuery("select p from Person p where p.gender = 0");
        List<Person> persons = query.getResultList();
        return persons;
	}	

}
