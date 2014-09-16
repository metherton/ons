package com.martinetherton.ons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martinetherton.ons.model.SearchQuery;
import com.martinetherton.ons.model.SearchResult;
import com.martinetherton.ons.model.SearchResultFactory;
import com.martinetherton.ons.persist.PersonRepository;

@Service
public class SearchServiceImpl implements SearchService {

	private PersonRepository personRepository;

	@Autowired
	public SearchServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public List<SearchResult> search(SearchQuery searchQuery) {
		// TODO Auto-generated method stub
		List<SearchResult> searchResults = SearchResultFactory.create(personRepository.findBy(searchQuery.getSurname()));
		return searchResults;
	}

}
