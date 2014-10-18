package com.martinetherton.ons.model;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.martinetherton.ons.model.PersonDetails.Builder;

public class PersonDetails {

	public PersonDetails() {
		
	}
	
	public static class Builder {

		private final Person person;
		private Person father;
		private Person mother;
		private List<Marriage> marriages = new ArrayList<Marriage>();
		
		public Builder(Person person) {
			this.person = person;
		}

		public Builder withMarriages(List<Marriage> val) {
			marriages = val;
			return this;
		}

		public Builder withFather(Person val) {
			father = val;
			return this;
		}

		public Builder withMother(Person val) {
			mother = val;
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
	private Person father;
	private Person mother;

	private PersonDetails(Builder builder) {
		person = builder.person;
		marriages = builder.marriages;
		father = builder.father;
		mother = builder.mother;
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
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return getFather() == null ? "" : getFather().getFirstName() + " " + getFather().getSurname().getSurname()+ " " + format.format(getFather().getBirthDate());
	}

	private Person getFather() {
		return father;
	}

	public String getMotherDetails() {
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return getMother() == null ? "" : getMother().getFirstName() + " " + getMother().getSurname().getSurname() + " " + format.format(getMother().getBirthDate());
	}

	private Person getMother() {
		return mother;
	}

	public String getBirthDate() {
		Format formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.format(person.getBirthDate());
	}

	public String getPersonSummary() {
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return person.getFirstName() + " " + person.getSurname().getSurname() + " " + format.format(person.getBirthDate());
	}
	
}
