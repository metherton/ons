package com.martinetherton.ons.model;

public class SearchResult {

	private String surname;
	private String firstName;
	private String birthDate;

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSurname() {
		return surname;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

}
