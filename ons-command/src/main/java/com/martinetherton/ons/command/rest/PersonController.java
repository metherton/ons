package com.martinetherton.ons.command.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.model.PersonDetails;
import com.martinetherton.ons.model.SearchResult;
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
		return personService.getPersonDetails(id);
	}	
	
//	@RequestMapping(value = "/persons", method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.CREATED)
//	public HttpEntity<String> createPerson(@RequestBody PersonDetails newPerson,
//			@Value("#{request.requestURL}") StringBuffer url) {
//		Person person = Person.Builder(newPerson.getFirstName(), newPerson.getSurname)
//		Person person = personService.addPerson(newPerson);
//
//		return entityWithLocation(url, person.getEntityId());
//	}		

	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public @ResponseBody List<PersonDetails> listAllPersons() {
		List<PersonDetails> listAllPersonDetails = personService.listAllPersonDetails();
		return listAllPersonDetails;		
	}		

//	@RequestMapping(value = "/persons", method = RequestMethod.GET)
//	public @ResponseBody List<Person> listAllPersons() {
//		List<Person> listAllPersonDetails = personService.listAllPersonDetails();
//		return listAllPersonDetails;
//	}		
	
	
	private HttpEntity<String> entityWithLocation(StringBuffer url,
			Object resourceId) {
		// Configure and return an HttpEntity object - it will be used to build
		// the HttpServletResponse
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(getLocationForChildResource(url, resourceId));
		return new HttpEntity<String>(headers);
	}

	/**
	 * determines URL of child resource based on the full URL of the given
	 * request, appending the path info with the given childIdentifier using a
	 * UriTemplate.
	 */
	private URI getLocationForChildResource(StringBuffer url,
			Object childIdentifier) {
		UriTemplate template = new UriTemplate(url.append("/{childId}")
				.toString());
		return template.expand(childIdentifier);
	}	
	
	
	
}
