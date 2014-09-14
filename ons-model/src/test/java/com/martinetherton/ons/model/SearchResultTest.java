package com.martinetherton.ons.model;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SearchResultTest {

	@Test
	public void searchResultSetterAndGetters() {
		
		SearchResult searchResult = new SearchResult();
		searchResult.setSurname("Etherton");
		
		assertThat(searchResult.getSurname(), is("Etherton"));
	}
	
}
