package com.martinetherton.ons.service;

import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.Mockito;

import com.martinetherton.ons.model.SearchQuery;
import com.martinetherton.ons.model.Surname;
import com.martinetherton.ons.persist.PersonRepository;

public class SearchServiceImplTest {

	@Test
	public void searchBySurname() {
		PersonRepository personRepository = mock(PersonRepository.class);;
		SearchService searchService = new SearchServiceImpl(personRepository);
		SearchQuery searchQuery = new SearchQuery();
		Surname surname = new Surname("Etherton");
		searchQuery.setSurname(surname);
		searchService.search(searchQuery);
		Mockito.verify(personRepository.findPersonsWith(surname));
	}

 
}
