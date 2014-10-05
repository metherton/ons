package com.martinetherton.ons.command.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.model.PersonDetails;
import com.martinetherton.ons.model.SearchResult;
import com.martinetherton.ons.model.Surname;
import com.martinetherton.ons.service.PersonDetailsService;
import com.martinetherton.ons.service.PersonService;
import com.martinetherton.ons.service.SurnameService;

@Controller
public class SurnameController {

	private SurnameService surnameService;

	@Autowired
	public SurnameController(SurnameService surnameService) {
		this.surnameService = surnameService;
	}

	@RequestMapping(value = "/surnames", method = RequestMethod.GET)
	public @ResponseBody List<Surname> listAllSurnames() {
		return surnameService.getSurnames();
	}	
}