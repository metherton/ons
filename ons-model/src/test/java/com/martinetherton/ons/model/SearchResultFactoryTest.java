package com.martinetherton.ons.model;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;

public class SearchResultFactoryTest {

	@Test
	public void searchResultsCreatedFromListOfPersons() {
		Person person1 = new Person();
		person1.setFirstName("Martin");
		person1.setSurname(new Surname("Etherton"));
        Calendar cal = Calendar.getInstance();
        cal.set(1963, 2, 4);
        Date myBirthDate = cal.getTime();
        person1.setBirthDate(myBirthDate);
		Person person2 = new Person();
		person2.setFirstName("John");
		person2.setSurname(new Surname("Smith"));
		person2.setBirthDate(myBirthDate);
		List<Person> persons = new ArrayList(Arrays.asList(person1, person2));
		List<SearchResult> searchResults = SearchResultFactory.create(persons);
		assertThat(searchResults.size(), is(2));
		assertThat(searchResults.get(0).getSurname(), Matchers.is("Etherton"));
		assertThat(searchResults.get(1).getSurname(), Matchers.is("Smith"));
		assertThat(searchResults.get(0).getFirstName(), Matchers.is("Martin"));
		assertThat(searchResults.get(1).getFirstName(), Matchers.is("John"));	
		assertThat(searchResults.get(0).getBirthDate(), Matchers.is("04 Mar 1963"));		
	}
	
}
