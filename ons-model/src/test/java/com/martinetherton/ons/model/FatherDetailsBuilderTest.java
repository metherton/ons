package com.martinetherton.ons.model;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class FatherDetailsBuilderTest {

	@Test
	public void fatherDetailsBuilder() {
		Person person = new Person();
		person.setEntityId(1L);
		person.setFirstName("Martin");
		person.setSurname(new Surname("Etherton"));
		
		FatherDetails fatherDetails = new FatherDetails.Builder(person).build();
		Assert.assertThat(fatherDetails.getPerson().getFirstName(), Matchers.is("Martin"));
		Assert.assertThat(fatherDetails.getFatherDetails(), Matchers.is("Martin Etherton"));
	}
		
	
	
}
