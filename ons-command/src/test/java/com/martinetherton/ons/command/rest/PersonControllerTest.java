package com.martinetherton.ons.command.rest;


import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;

import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.model.PersonDetails;
import com.martinetherton.ons.service.PersonDetailsService;
import com.martinetherton.ons.service.PersonDetailsServiceImpl;
import com.martinetherton.ons.service.PersonService;
import com.martinetherton.ons.service.PersonServiceImpl;

public class PersonControllerTest {

	private PersonController controller;
	
	private PersonService personService;
	private PersonDetailsService personDetailsService;
	
	@Before
	public void setUp() {
		personService = Mockito.mock(PersonServiceImpl.class);
		personDetailsService = Mockito.mock(PersonDetailsServiceImpl.class);
		controller = new PersonController(personService, personDetailsService);
	}
	
	@Test
	public void handlePersonRequest() {
		Person expectedPerson = new Person();
		expectedPerson.setFirstName("John");
		PersonDetails expectedPersonDetails = new PersonDetails.Builder(expectedPerson).build();
		Mockito.when(personService.getPersonDetails(1)).thenReturn(expectedPersonDetails);
		PersonDetails personDetails = controller.personDetails(1L);
		Mockito.verify(personService).getPersonDetails(1L);
		assertThat(personDetails.getPerson().getFirstName(), Matchers.is("John"));
	}
	
	@Test
	public void getAddPersonForm() {
		List<PersonDetails> personDetails = new ArrayList<PersonDetails>();
		personDetails.add(new PersonDetails());
		Mockito.when(personService.listAllPersonDetails()).thenReturn(personDetails);
		AddPersonForm addPersonForm = controller.getAddPersonForm();
		Assert.assertThat(addPersonForm.personDetails().size(), Matchers.is(1));		
		Mockito.verify(personService).listAllPersonDetails();
	}
	
}
