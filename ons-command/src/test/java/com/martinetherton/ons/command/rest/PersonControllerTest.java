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
import com.martinetherton.ons.model.Surname;
import com.martinetherton.ons.service.PersonDetailsService;
import com.martinetherton.ons.service.PersonDetailsServiceImpl;
import com.martinetherton.ons.service.PersonService;
import com.martinetherton.ons.service.PersonServiceImpl;
import com.martinetherton.ons.service.SurnameService;
import com.martinetherton.ons.service.SurnameServiceImpl;

public class PersonControllerTest {

	private PersonController controller;
	
	private PersonService personService;
	private PersonDetailsService personDetailsService;
	private SurnameService surnameService;
	
	@Before
	public void setUp() {
		personService = Mockito.mock(PersonServiceImpl.class);
		surnameService = Mockito.mock(SurnameServiceImpl.class);
		personDetailsService = Mockito.mock(PersonDetailsServiceImpl.class);
		controller = new PersonController(personService, personDetailsService, surnameService);
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
		List<Surname> surnames = new ArrayList<Surname>();
		surnames.add(new Surname());
		Mockito.when(surnameService.getSurnames()).thenReturn(surnames);
		AddPersonForm addPersonForm = controller.getAddPersonForm();
		Assert.assertThat(addPersonForm.getPersonDetails().size(), Matchers.is(1));		
		Assert.assertThat(addPersonForm.getSurnames().size(), Matchers.is(1));	
		Mockito.verify(personService).listAllPersonDetails();
		Mockito.verify(surnameService).getSurnames();
	}
	
}
