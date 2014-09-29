package com.martinetherton.ons.command.rest;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
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
		Mockito.when(personDetailsService.getPersonDetails(Matchers.any(Person.class))).thenReturn(expectedPersonDetails);
		PersonDetails personDetails = controller.personDetails(1L);
		Mockito.verify(personDetailsService).getPersonDetails(Matchers.any(Person.class));
		assertThat(personDetails.getPerson().getFirstName(), is("John"));
	}
}
