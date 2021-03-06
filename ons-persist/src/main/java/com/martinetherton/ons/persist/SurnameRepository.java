package com.martinetherton.ons.persist;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.martinetherton.ons.model.Surname;

public interface SurnameRepository {

    Surname findBy(long i);
    public List<Surname> findAll();
    public Surname findByName(String name);
    public Long getSurnameCount();
    void generateSurnameFile(PrintWriter out);
    Surname findByNameFromResultSet(String string);
    int insert(Surname surname);
    int update(Surname surname);
    String findLastSurname();
    Long findNumberOfSurnamesGreaterThanLetter(String letter);
    Map findSurnameAsMap(long id);
    List<Surname> findAllSurnameInfo();
    public void init();
    
    void setEntityManager(EntityManager entityManager);
    Surname save(Surname surname);
    
}
