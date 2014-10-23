package com.martinetherton.ons.model;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class PersonDetailsBuilderTest {

	@Test
	public void personDetailsBuilder() {
		Person person = new Person();
		person.setEntityId(1L);
		person.setFirstName("Martin");
		person.setSurname(new Surname("Etherton"));
		person.setBirthDate(new Date());
		Person partner = new Person();
		partner.setEntityId(2L);
		partner.setFirstName("Erna");
		
		Person father = new Person();
		father.setSurname(new Surname("Smith"));
		father.setFirstName("Sid");
		father.setBirthDate(new Date());

		Person mother = new Person();
		mother.setSurname(new Surname("Jones"));
		mother.setFirstName("Nora");
		mother.setBirthDate(new Date());
		
		Long fatherId = 3L;
		person.setFatherId(fatherId );
		Long motherId = 4L;
		person.setMotherId(motherId );
		
		Marriage marriage = new Marriage();
		marriage.setPerson(person);
		marriage.setPartner(partner);	
		
		List<Marriage> marriages = new ArrayList<Marriage>();
		marriages.add(marriage);
		
		PersonDetails personDetails = new PersonDetails.Builder(person).withMarriages(marriages).withFather(father).withMother(mother).build();
		assertThat(personDetails.getPerson().getFirstName(), Matchers.is("Martin"));
		assertThat(personDetails.getMarriages().get(0).getPartner().getFirstName(), Matchers.is("Erna"));
		assertThat(personDetails.getFatherDetails(), Matchers.startsWith("Sid Smith"));
		assertThat(personDetails.getMotherDetails(), Matchers.startsWith("Nora Jones"));
		assertThat(personDetails.getPersonSummary(), Matchers.startsWith("Martin Etherton"));
	}
	
}
