package com.martinetherton.ons.model;

public class SearchResult {

	private String surname;
	private String firstName;
	private String birthDate;
	private String entityId;
	private String fatherDetails;
	private String motherDetails;

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

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getFatherDetails() {
		return fatherDetails;
	}

	public String getMotherDetails() {
		return motherDetails;
	}

	public void setFatherDetails(String fatherDetails) {
		this.fatherDetails = fatherDetails;
	}

	public void setMotherDetails(String motherDetails) {
		this.motherDetails = motherDetails;
	}

}
