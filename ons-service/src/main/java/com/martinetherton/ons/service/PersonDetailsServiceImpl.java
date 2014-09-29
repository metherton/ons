package com.martinetherton.ons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martinetherton.ons.model.Marriage;
import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.model.PersonDetails;
import com.martinetherton.ons.persist.MarriageRepository;
import com.martinetherton.ons.persist.PersonRepository;

@Service
public class PersonDetailsServiceImpl implements PersonDetailsService {

	private PersonRepository personRepository;
	private MarriageRepository marriageRepository;

	@Autowired
	public PersonDetailsServiceImpl(PersonRepository personRepository, MarriageRepository marriageRepository) {
		this.personRepository = personRepository;
		this.marriageRepository = marriageRepository;
	}

	@Transactional(readOnly = true)
	public PersonDetails getPersonDetails(Person person) {
		Person retrievedPerson = personRepository.findBy(person.getEntityId());
		List<Marriage> retrievedMarriages = marriageRepository.findMarriagesFor(person);
		return new PersonDetails.Builder(retrievedPerson).withMarriages(retrievedMarriages).build();
	}

}
