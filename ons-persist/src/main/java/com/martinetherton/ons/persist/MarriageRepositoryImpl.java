package com.martinetherton.ons.persist;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import com.martinetherton.ons.model.Location;
import com.martinetherton.ons.model.Marriage;
import com.martinetherton.ons.model.Person;

@Repository
public class MarriageRepositoryImpl implements MarriageRepository {

    private EntityManager entityManager;

    @PersistenceContext
    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Marriage findBy(long id) {
        return entityManager.find(Marriage.class, id);
    }

	@Override
	public List<Marriage> findMarriagesFor(Person person) {
		Query query = entityManager.createQuery("select m from Marriage m where m.person = :person");
		query.setParameter("person", person);
		return query.getResultList();
	}
    
}
