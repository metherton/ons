package com.martinetherton.ons.model;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class FatherTest {

	@Test
	public void settersAndGetters() {		
		Father father = new Father();
		father.setEntityId(1L);
		Person person = new Person();
		father.setPerson(person);
		Assert.assertThat(father.getEntityId(), Matchers.is(1L));
		Assert.assertThat(father.getPerson(), Matchers.is(person));		
	}
	
}
