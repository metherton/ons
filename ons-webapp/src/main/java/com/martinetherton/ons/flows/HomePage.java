package com.martinetherton.ons.flows;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class HomePage implements Serializable {

	private List<String> surnameList = new ArrayList<String>(Arrays.asList("Wilkinson", "Fink", "Etherton", "Bell"));
	private String surname;
	
	public HomePage() {
		
	}
	
	public List<String> getSurnameList() {
		return surnameList;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setSurnameList(List<String> surnameList) {
		this.surnameList = surnameList;
	}
	
	public String search() {
		return "searchListResults";
	}
	
	public String getCurrentYear() {
		return "2014";
	}
}
