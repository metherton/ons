package com.martinetherton.ons.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SearchCriteriaTest {

	@Test
	public void gettersAndSetters() {
		SearchCriteria searchCriteria = new SearchCriteria();
		List<Surname> surnameList = new ArrayList<Surname>();
		Surname surname = new Surname();
		surname.setSurname("Smith");
		surnameList.add(surname);
		searchCriteria.setSurnameList(surnameList );
		assertEquals("Smith", searchCriteria.getSurnameList().get(0).getSurname());
	}
	
}
