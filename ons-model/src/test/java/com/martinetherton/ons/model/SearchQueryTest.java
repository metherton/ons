package com.martinetherton.ons.model;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class SearchQueryTest {

	@Test
	public void searchQuerySettersAndGetters() {
		SearchQuery searchQuery = new SearchQuery();
		searchQuery.setSurname("Etherton");
		assertThat(searchQuery.getSurname(), Matchers.is("Etherton"));
	}
	
}
