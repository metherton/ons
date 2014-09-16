package com.martinetherton.ons.flows;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.martinetherton.ons.model.SearchQuery;
import com.martinetherton.ons.model.SearchResult;
import com.martinetherton.ons.model.Surname;
import com.martinetherton.ons.service.SearchService;

@Named
@SessionScoped
public class HomePage implements Serializable {

	private List<String> surnameList = new ArrayList<String>(Arrays.asList("Wilkinson", "Fink", "Etherton", "Bell"));
	private String surname;
	@Inject
	private SearchService searchService;
	private List<SearchResult> searchResults;
	
	public HomePage() {
		
	}
	
	public List<String> getSurnameList() {
		return surnameList;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setSurnameList(List<String> surnameList) {
		this.surnameList = surnameList;
	}
	
	public String search() {
		SearchQuery query = new SearchQuery();
		query.setSurname(new Surname(surname));
		setSearchResults(searchService.search(query));
		return "searchListResults";
	}
	
	public String getCurrentYear() {
		return "2014";
	}

	public List<SearchResult> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(List<SearchResult> searchResults) {
		this.searchResults = searchResults;
	}
}
