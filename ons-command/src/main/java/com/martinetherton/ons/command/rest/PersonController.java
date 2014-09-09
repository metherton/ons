package com.martinetherton.ons.command.rest;

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
	private SurnameService surnameService;

	@Autowired
	public PersonController(PersonService personService, SurnameService surnameService) {
		this.personService = personService;
		this.surnameService = surnameService;
	}

	@RequestMapping(value = "/persons/{personId}", method = RequestMethod.GET)
	public @ResponseBody Person personDetails(@PathVariable("personId") long id) {
		Person person = personService.getPerson(id);
		return person;
	}

	@RequestMapping(value = "/surnames/{surnameId}", method = RequestMethod.GET)
	public @ResponseBody Surname surnameDetails(@PathVariable("surnameId") long id) {
		Surname person = surnameService.getSurname(id);
		return person;
	}	
	
}
