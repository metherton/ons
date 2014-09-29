package com.martinetherton.ons.service;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.martinetherton.ons.model.Marriage;
import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.model.PersonDetails;
import com.martinetherton.ons.persist.MarriageRepository;
import com.martinetherton.ons.persist.MarriageRepositoryImpl;
import com.martinetherton.ons.persist.PersonRepository;
import com.martinetherton.ons.persist.PersonRepositoryImpl;

public class PersonDetailsServiceImplTest {

	private PersonDetailsService personDetailsService;
	private PersonRepository personRepository;
	private MarriageRepository marriageRepository;


	@Before
	public void setUp() {
		personRepository = Mockito.mock(PersonRepositoryImpl.class);
		marriageRepository = Mockito.mock(MarriageRepositoryImpl.class);
		personDetailsService = new PersonDetailsServiceImpl(personRepository, marriageRepository);
	}
	
    @Test
    public void getPersonDetails() {
    	Person person = new Person();
    	person.setEntityId(1L);
    	person.setFirstName("fred");
    	
    	Person retrievedPerson = new Person();
    	retrievedPerson.setFirstName("fred");
    	retrievedPerson.setEntityId(1L);
    	Marriage retrievedMarriage = new Marriage();
    	List<Marriage> retrievedMarriages = new ArrayList<Marriage>();
    	retrievedMarriages.add(retrievedMarriage);
    	
    	Mockito.when(personRepository.findBy(1L)).thenReturn(retrievedPerson);
    	Mockito.when(marriageRepository.findMarriagesFor(person)).thenReturn(retrievedMarriages); 	
    	
    	PersonDetails personDetails = personDetailsService.getPersonDetails(person);
    	
    	Assert.assertThat(personDetails.getPerson().getFirstName(), Matchers.is("fred"));
    	Assert.assertThat(personDetails.getMarriages().size(), Matchers.is(1));
    	
    	Mockito.verify(personRepository).findBy(1L);
    	Mockito.verify(marriageRepository).findMarriagesFor(person);
    }
    	
}
