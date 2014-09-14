package com.martinetherton.ons.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.martinetherton.ons.model.SearchQuery;
import com.martinetherton.ons.model.SearchResult;

public class SearchServiceIntegrationTest extends ServiceIntegrationTest {

	@Autowired
	private SearchService searchService;
	
	@Test
	public void searchBySurnameShouldReturnSearchResults() {
		
		SearchQuery query;
		List<SearchResult> searchResults = searchService.search(query);
		
	}
	
}
