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
import com.martinetherton.ons.model.Surname;
import com.martinetherton.ons.service.PersonService;
import com.martinetherton.ons.service.SurnameService;

@Controller
public class PersonController {

	private PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping(value = "/persons/{personId}", method = RequestMethod.GET)
	public @ResponseBody List<Person> personDetails(@PathVariable("personId") long id) {
		List<Person> persons = new ArrayList<Person>();
		Person person = personService.getPerson(id);
		persons.add(person);
		return persons;
	}	
	
}
