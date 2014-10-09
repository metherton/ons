package com.martinetherton.ons.service;

import java.util.List;

import com.martinetherton.ons.model.Person;

public interface PersonService {

    Person getPerson(long id);

    Person addPerson(Person pToInsert);

    void pointcut1();
    void pointcut2();
    void pointcutWithParam(String name);

	List<Person> listAllPersons();
    
}
