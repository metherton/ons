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
		Father father = new Father();
		father.setEntityId(1L);
		Mother mother = new Mother();
		mother.setEntityId(1L);
		
		String firstName = "Martin";
		Surname surname = new Surname("Smith");
		Date birthDate = new Date();
		Long entityId = 1L;
		
		Person person = new Person.Builder(entityId, firstName, surname, birthDate, 1).withFather(father).withMother(mother).build();
		assertThat(person.getFirstName(), Matchers.is("Martin"));
		assertThat(person.getFather(), Matchers.is(father));
		assertThat(person.getMother(), Matchers.is(mother));
		assertThat(person.getBirthDate(), Matchers.is(birthDate));
		assertThat(person.getEntityId(), Matchers.is(1L));
		assertThat(person.getGender(), Matchers.is(1));
		
	}
	
	
}
