package com.martinetherton.ons.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.martinetherton.ons.model.SearchQuery;
import com.martinetherton.ons.model.SearchResult;
import com.martinetherton.ons.model.Surname;

public class SearchServiceIntegrationTest extends ServiceIntegrationTest {

	@Autowired
	private SearchService searchService;
	
	@Test
	public void searchBySurnameShouldReturnSearchResults() {
		SearchQuery query = new SearchQuery();
		query.setSurname(new Surname("Etherton"));
		List<SearchResult> searchResults = searchService.search(query);
		assertThat(searchResults.size(), is(4));
		assertThat(searchResults.get(0).getSurname(), Matchers.is("Etherton"));
	}
	
}
