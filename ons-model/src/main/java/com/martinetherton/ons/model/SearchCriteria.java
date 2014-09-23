package com.martinetherton.ons.model;

import java.util.List;

public class SearchCriteria {

	private List<Surname> surnameList;

	public void setSurnameList(List<Surname> surnameList) {
		this.surnameList = surnameList;
	}

	public List<Surname> getSurnameList() {
		return surnameList;
	}

}
