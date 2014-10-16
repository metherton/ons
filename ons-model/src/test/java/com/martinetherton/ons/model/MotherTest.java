package com.martinetherton.ons.model;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class MotherTest {

	@Test
	public void settersAndGetters() {		
		Mother mother = new Mother();
		mother.setEntityId(1L);
		Person person = new Person();
		mother.setPerson(person);
		Assert.assertThat(mother.getEntityId(), Matchers.is(1L));
		Assert.assertThat(mother.getPerson(), Matchers.is(person));		
	}	
	
}
