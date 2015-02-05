package com.martinetherton.ons.command.rest;
import java.util.ArrayList;
import java.util.List;

import com.martinetherton.ons.model.Location;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.model.PersonDetails;
import com.martinetherton.ons.model.Surname;

public class PersonsFormBuilderTest {

	@Test
	public void addPersonFormBuilderShouldBuildForm() {
		List<PersonDetails> personDetails = new ArrayList<PersonDetails>();
		personDetails.add(new PersonDetails());
		personDetails.add(new PersonDetails());		
		Person addedPerson = new Person();
		List<Surname> surnames = new ArrayList<Surname>();
		surnames.add(new Surname());
		surnames.add(new Surname());
        List<Location> locations = new ArrayList<Location>();
        locations.add(new Location());
        locations.add(new Location());
		List<PersonDetails> motherDetails = new ArrayList<PersonDetails>();
		List<PersonDetails> fatherDetails = new ArrayList<PersonDetails>();
		PersonsForm personsForm = new PersonsForm.Builder(personDetails, addedPerson, surnames, fatherDetails, motherDetails, locations).build();
		Assert.assertThat(personsForm.getPersonDetails().size(), Matchers.is(2));
		Assert.assertThat(personsForm.getAddedPerson(), Matchers.is(addedPerson));
	}
	
}
