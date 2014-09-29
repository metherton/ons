package com.martinetherton.ons.service;

import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.model.PersonDetails;

public interface PersonDetailsService {

	PersonDetails getPersonDetails(Person person);

}
