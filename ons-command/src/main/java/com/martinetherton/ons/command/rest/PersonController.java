package com.martinetherton.ons.command.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.model.PersonDetails;
import com.martinetherton.ons.model.Surname;
import com.martinetherton.ons.service.PersonDetailsService;
import com.martinetherton.ons.service.PersonService;
import com.martinetherton.ons.service.SurnameService;

@Controller
public class PersonController {

	private PersonService personService;
	private PersonDetailsService personDetailsService;

	@Autowired
	public PersonController(PersonService personService, PersonDetailsService personDetailsService) {
		this.personService = personService;
		this.personDetailsService = personDetailsService;
	}

	@RequestMapping(value = "/persons/{personId}", method = RequestMethod.GET)
	public @ResponseBody PersonDetails personDetails(@PathVariable("personId") long id) {
		Person person = new Person();
		person.setEntityId(id);
		PersonDetails personDetails = personDetailsService.getPersonDetails(person);
		return personDetails;
	}	
	
}
