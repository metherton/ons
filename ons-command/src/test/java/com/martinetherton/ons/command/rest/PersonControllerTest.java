package com.martinetherton.ons.command.rest;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.service.PersonService;
import com.martinetherton.ons.service.PersonServiceImpl;
import com.martinetherton.ons.service.SurnameService;
import com.martinetherton.ons.service.SurnameServiceImpl;

public class PersonControllerTest {

	private PersonController controller;
	private PersonService personService;
	
	@Before
	public void setUp() {
		personService = Mockito.mock(PersonServiceImpl.class);
		controller = new PersonController(personService);
	}
	
	@Test
	public void handlePersonRequest() {
		Person expectedPerson = new Person();
		expectedPerson.setFirstName("John");
		Mockito.when(personService.getPerson(1)).thenReturn(expectedPerson);
		Person person = controller.personDetails(1L);
		verify(personService).getPerson(1L);
		assertThat(person.getFirstName(), Matchers.is("John"));
	}
}
