package com.martinetherton.ons.service;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.martinetherton.ons.model.Person;

public class PersonDetailsServiceIntegrationTest extends ServiceIntegrationTest {

    @Autowired
    PersonDetailsService personDetailsService;
    
    @Test
    public void getPerson() {
    	Person person = new Person();
    	person.setEntityId(5L);
        Assert.assertThat(personDetailsService.getPersonDetails(person).getPerson().getFirstName(), Matchers.is("Sydney"));
        Assert.assertThat(personDetailsService.getPersonDetails(person).getMarriages().get(0).getPartner().getFirstName(), Matchers.is("Nora"));
    }
	
}
