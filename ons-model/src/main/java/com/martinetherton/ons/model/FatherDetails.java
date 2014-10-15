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
		// TODO Auto-generated method stub
		return null;
	}

	public String getFatherDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
