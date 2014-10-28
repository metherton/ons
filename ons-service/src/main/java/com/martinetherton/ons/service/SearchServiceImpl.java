package com.martinetherton.ons.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martinetherton.ons.model.SearchCriteria;
import com.martinetherton.ons.model.SearchQuery;
import com.martinetherton.ons.model.SearchResult;
import com.martinetherton.ons.model.SearchResultFactory;
import com.martinetherton.ons.persist.PersonRepository;
import com.martinetherton.ons.persist.SurnameRepository;

@Service
public class SearchServiceImpl implements Serializable, SearchService {

	private PersonRepository personRepository;
	private SurnameRepository surnameRepository;

	@Autowired
	public SearchServiceImpl(PersonRepository personRepository, SurnameRepository surnameRepository) {
		this.personRepository = personRepository;
		this.surnameRepository = surnameRepository;
	}

	@Override
	public List<SearchResult> search(SearchQuery searchQuery) {
		List<SearchResult> searchResults = SearchResultFactory.create(personRepository.findBy(searchQuery.getSurname()));
		return searchResults;
	}

	@Override
	public List<SearchResult> listAllPersons() {
		List<SearchResult> searchResults = SearchResultFactory.create(personRepository.findAll());
		return searchResults;
	}	
	
	@Override
	public SearchCriteria searchCriteria() {
		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setSurnameList(surnameRepository.findAll());
		return searchCriteria;
	}

}
