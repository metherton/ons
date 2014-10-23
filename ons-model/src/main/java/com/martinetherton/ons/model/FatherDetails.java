package com.martinetherton.ons.model;

public class FatherDetails {

	private Person person;

	public FatherDetails(Builder builder) {
		person = builder.person;
	}

	public static class Builder {

		public Person person;

		public Builder(Person person) {
			this.person = person;
		}

		public FatherDetails build() {
			return new FatherDetails(this);
		}

	}

	public Person getPerson() {
		return person;
	}

	public String getFatherDetails() {
		return person.getFirstName() + " " + person.getSurname().getSurname();
	}

}
