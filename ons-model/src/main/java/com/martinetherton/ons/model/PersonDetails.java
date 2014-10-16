package com.martinetherton.ons.model;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PersonDetails {

	public PersonDetails() {
		
	}
	
	public static class Builder {

		private final Person person;
		private List<Marriage> marriages = new ArrayList<Marriage>();
		
		public Builder(Person person) {
			this.person = person;
		}

		public Builder withMarriages(List<Marriage> val) {
			marriages = val;
			return this;
		}

		public PersonDetails build() {
			return new PersonDetails(this);
		}
	}

	private Person person;
	private List<Marriage> marriages;
	private String birthDate;
	private String personSummary;

	private PersonDetails(Builder builder) {
		person = builder.person;
		marriages = builder.marriages;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setMarriages(List<Marriage> marriages) {
		this.marriages = marriages;
	}

	public Person getPerson() {
		return person;
	}

	public List<Marriage> getMarriages() {
		return marriages;
	}

	public String getFatherDetails() {
		return person.getFather() == null ? "" : person.getFather().getPerson().getFirstName() + " " + person.getFather().getPerson().getSurname().getSurname();

	}

	public String getMotherDetails() {
		return person.getMother() == null ? "" : person.getMother().getPerson().getFirstName() + " " + person.getMother().getPerson().getSurname().getSurname();
	}

	public String getBirthDate() {
		Format formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.format(person.getBirthDate());
	}

	public String getPersonSummary() {
		return person.getFirstName() + " " + person.getSurname().getSurname();
	}
	
}
