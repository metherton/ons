package com.martinetherton.ons.service;

import static org.junit.Assert.assertThat;

import java.util.Date;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.martinetherton.ons.model.Father;
import com.martinetherton.ons.model.Mother;
import com.martinetherton.ons.model.Person;

public class PersonServiceIntegrationTest extends ServiceIntegrationTest {

    @Autowired
    PersonService personService;
    
    @Test
    public void getPerson() {
        Assert.assertThat(personService.getPerson(0).getFirstName(), Matchers.is("Martin"));
        Assert.assertThat(personService.getPerson(0).getFatherId(), Matchers.is(5L));
    }
    
    @Test
    public void insertPerson() {
        Person pToInsert = new Person();
        pToInsert.setFatherId(3L);
        pToInsert.setMotherId(6L);
        System.out.println("entityId is " + pToInsert.getEntityId());
        pToInsert.setFirstName("PToInsert");
        pToInsert.setBirthDate(new Date());
        Person personInserted = personService.addPerson(pToInsert);
        assertThat(personInserted.getFirstName(), Matchers.is("PToInsert"));
        assertThat(personInserted.getEntityId(), Matchers.is(6L));
    }
    
    @Test
    public void pointcutMethod() {
        personService.pointcut1();
        personService.pointcut2();
        personService.pointcutWithParam("Martin");
    }
    
}