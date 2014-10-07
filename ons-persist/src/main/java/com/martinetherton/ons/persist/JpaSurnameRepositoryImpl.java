package com.martinetherton.ons.persist;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.model.Surname;

@Repository
public class JpaSurnameRepositoryImpl implements SurnameRepository {

	private EntityManager entityManager;
	
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }	
	
	@Override
	public Surname findBy(long i) {
		// TODO Auto-generated method stub
        return entityManager.find(Surname.class, i);
	}

	@Override
	public List<Surname> findAll() {
        Query query = entityManager.createQuery("select s from Surname s");
        List<Surname> surnames = query.getResultList();
        return surnames;
	}

	@Override
	public Surname findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSurnameCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void generateSurnameFile(PrintWriter out) {
		// TODO Auto-generated method stub

	}

	@Override
	public Surname findByNameFromResultSet(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Surname surname) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Surname surname) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String findLastSurname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findNumberOfSurnamesGreaterThanLetter(String letter) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map findSurnameAsMap(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Surname> findAllSurnameInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public Surname save(Surname surname) {
		entityManager.persist(surname);
		return surname;
	}

}
