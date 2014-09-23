package com.martinetherton.ons.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.martinetherton.ons.model.SearchCriteria;
import com.martinetherton.ons.model.SearchQuery;
import com.martinetherton.ons.model.Surname;
import com.martinetherton.ons.persist.PersonRepository;
import com.martinetherton.ons.persist.SurnameRepository;

public class SearchServiceImplTest {

	private static final String SMITH = "Smith";
	private PersonRepository personRepository;
	private SearchService searchService;
	private SurnameRepository surnameRepository;

	@Before
	public void setUp() {
		personRepository = mock(PersonRepository.class);
		surnameRepository = mock(SurnameRepository.class);
		searchService = new SearchServiceImpl(personRepository, surnameRepository);		
	}
	
	@Test
	public void searchBySurname() {
		SearchQuery searchQuery = new SearchQuery();
		Surname surname = new Surname("Etherton");
		searchQuery.setSurname(surname);
		searchService.search(searchQuery);
		verify(personRepository).findBy(surname);
	}
	
	@Test
	public void searchCriteriaCreation() {
		Surname surname = new Surname();
		surname.setSurname(SMITH);
		List<Surname> surnames = new ArrayList<Surname>();
		surnames.add(surname);
		Mockito.when(surnameRepository.findAll()).thenReturn(surnames);
		SearchCriteria searchCriteria = searchService.searchCriteria();
		verify(surnameRepository).findAll();
		assertThat(searchCriteria.getSurnameList().get(0).getSurname(), is(SMITH));
	}

 
}
