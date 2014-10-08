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
		person1.setEntityId(1L);
		person1.setFirstName("Martin");
		person1.setSurname(new Surname("Etherton"));
		Person father1 = new Person();
		father1.setFirstName("father1firstname");
		father1.setSurname(new Surname("father1surname"));
		person1.setFather(father1);
		Person mother1 = new Person();
		mother1.setFirstName("mother1firstname");
		mother1.setSurname(new Surname("mother1surname"));

		person1.setMother(mother1);

		Calendar cal = Calendar.getInstance();
        cal.set(1963, 2, 4);
        Date myBirthDate = cal.getTime();
        person1.setBirthDate(myBirthDate);
		Person person2 = new Person();
		person2.setEntityId(2L);
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
		assertThat(searchResults.get(0).getEntityId(), Matchers.is("1"));	
		assertThat(searchResults.get(0).getFatherDetails(), Matchers.is("father1firstname father1surname"));	
		assertThat(searchResults.get(0).getMotherDetails(), Matchers.is("mother1firstname mother1surname"));	

	}
	
}
