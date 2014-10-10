package com.martinetherton.ons.model;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;

public class PersonBuilderTest {

	@Test
	public void personBuilder() {		
		Person father = new Person();
		father.setFirstName("Sid");
		father.setSurname(new Surname("Smith"));
		Person mother = new Person();
		mother.setFirstName("Nora");
		mother.setSurname(new Surname("Jones"));
		
		String firstName = "Martin";
		Surname surname = new Surname("Smith");
		Date birthDate = new Date();
		Long entityId = 1L;
		
		Person person = new Person.Builder(entityId, firstName, surname, birthDate).withFather(father).withMother(mother).build();
		assertThat(person.getFirstName(), Matchers.is("Martin"));
		assertThat(person.getFather(), Matchers.is(father));
		assertThat(person.getMother(), Matchers.is(mother));
		assertThat(person.getBirthDate(), Matchers.is(birthDate));
		assertThat(person.getEntityId(), Matchers.is(1L));
	}
	
	
}
