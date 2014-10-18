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
		
		String firstName = "Martin";
		Surname surname = new Surname("Smith");
		Date birthDate = new Date();
		Long entityId = 1L;
		
		Long fatherId = 2L;
		Long motherId = 3L;
		Person person = new Person.Builder(entityId, firstName, surname, birthDate, 1).withFather(fatherId ).withMother(motherId ).build();
		assertThat(person.getFirstName(), Matchers.is("Martin"));
		assertThat(person.getFatherId(), Matchers.is(fatherId));
		assertThat(person.getMotherId(), Matchers.is(motherId));
		assertThat(person.getBirthDate(), Matchers.is(birthDate));
		assertThat(person.getEntityId(), Matchers.is(1L));
		assertThat(person.getGender(), Matchers.is(1));
		
	}
	
	
}
