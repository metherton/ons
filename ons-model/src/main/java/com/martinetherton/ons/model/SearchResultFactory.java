package com.martinetherton.ons.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SearchResultFactory {

	public static List<SearchResult> create(List<Person> persons) {
		List<SearchResult> searchResults = new ArrayList<SearchResult>();
		for (Person person : persons) {
			SearchResult searchResult = new SearchResult();
			searchResult.setSurname(person.getSurname().getSurname());
			searchResult.setFirstName(person.getFirstName());
			searchResult.setBirthDate(format(person.getBirthDate()));
			searchResults.add(searchResult);
		}
		return searchResults;
	}

	private static String format(Date birthDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
		return formatter.format(birthDate);
	}

}
