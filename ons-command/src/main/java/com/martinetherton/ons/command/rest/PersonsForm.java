package com.martinetherton.ons.command.rest;

import java.util.List;

import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.model.PersonDetails;
import com.martinetherton.ons.model.Surname;

public class PersonsForm {

	public static class Builder {

		private final List<PersonDetails> personDetails;
		public Person addedPerson;
		private List<Surname> surnames;
		public List<PersonDetails> fatherDetails;
		public List<PersonDetails> motherDetails;
		
		public Builder(List<PersonDetails> personDetails, Person addedPerson, List<Surname> surnames, List<PersonDetails> fatherDetails, List<PersonDetails> motherDetails) {
			this.personDetails = personDetails;
			this.addedPerson = addedPerson;
			this.surnames = surnames;
			this.fatherDetails = fatherDetails;
			this.motherDetails = motherDetails;
		}

		public PersonsForm build() {
			return new PersonsForm(this);
		}

	}

	private List<PersonDetails> personDetails;
	private Person addedPerson;
	private List<Surname> surnames;
	private List<PersonDetails> fatherDetails;
	private List<PersonDetails> motherDetails;

	private PersonsForm(Builder builder) {
		personDetails = builder.personDetails;
		addedPerson = builder.addedPerson;
		surnames = builder.surnames;
		fatherDetails = builder.fatherDetails;
		motherDetails = builder.motherDetails;
	}

	public List<PersonDetails> getPersonDetails() {
		return personDetails;
	}
	
	public List<PersonDetails> getFatherDetails() {
		return fatherDetails;
	}	

	public List<PersonDetails> getMotherDetails() {
		return motherDetails;
	}	
	
	public Person getAddedPerson() {
		return addedPerson;
	}

	public List<Surname> getSurnames() {
		return surnames;
	}



}
