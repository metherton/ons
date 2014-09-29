package com.martinetherton.ons.model;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
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
		Person partner = new Person();
		partner.setEntityId(2L);
		partner.setFirstName("Erna");

		Marriage marriage = new Marriage();
		marriage.setPerson(person);
		marriage.setPartner(partner);
		
		
		List<Marriage> marriages = new ArrayList<Marriage>();
		marriages.add(marriage);
		
		PersonDetails personDetails = new PersonDetails.Builder(person).withMarriages(marriages).build();
		assertThat(personDetails.getPerson().getFirstName(), Matchers.is("Martin"));
		assertThat(personDetails.getMarriages().get(0).getPartner().getFirstName(), Matchers.is("Erna"));
	}
	
}
