package com.martinetherton.ons.model;

import java.util.ArrayList;
import java.util.List;

public class SearchResultFactory {

	public static List<SearchResult> create(List<Person> persons) {
		List<SearchResult> searchResults = new ArrayList<SearchResult>();
		for (Person person : persons) {
			SearchResult searchResult = new SearchResult();
			searchResult.setSurname(person.getSurname().getSurname());
			searchResult.setFirstName(person.getFirstName());
			searchResults.add(searchResult);
		}
		return searchResults;
	}

}
