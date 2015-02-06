package com.martinetherton.ons.command.rest;

import java.net.URI;
import java.util.List;

import com.martinetherton.ons.service.LocationService;
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
import com.martinetherton.ons.service.PersonDetailsService;
import com.martinetherton.ons.service.PersonService;
import com.martinetherton.ons.service.SurnameService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class PersonController {

	private PersonService personService;
	private PersonDetailsService personDetailsService;
	private SurnameService surnameService;
    private LocationService locationService;

	@Autowired
	public PersonController(PersonService personService, PersonDetailsService personDetailsService, SurnameService surnameService, LocationService locationService) {
		this.personService = personService;
		this.personDetailsService = personDetailsService;
		this.surnameService = surnameService;
        this.locationService = locationService;
	}

	@RequestMapping(value = "/persons/{personId}", method = RequestMethod.GET)
	public @ResponseBody PersonDetails personDetails(@PathVariable("personId") long id) {
		PersonDetails personDetails = personService.getPersonDetails(id);
		return personDetails;
	}

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public @ResponseBody
    PersonsForm getAddPersonForm(HttpServletResponse response) {
        List<PersonDetails> listAllPersonDetails = personService.listAllPersonDetails();
        List<PersonDetails> listAllFatherDetails = personService.listAllMalePersonDetails();
        List<PersonDetails> listAllMotherDetails = personService.listAllFemalePersonDetails();
        PersonsForm personsForm = new PersonsForm.Builder(listAllPersonDetails,
                new Person(),
                surnameService.getSurnames(),
                listAllFatherDetails,
                listAllMotherDetails,
                locationService.getLocations()).build();


        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

        return personsForm;
    }
	
	@RequestMapping(value = "/persons", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public HttpEntity<String> createPerson(@RequestBody Person newPerson,
			@Value("#{request.requestURL}") StringBuffer url) {
		Person person = personService.addPerson(newPerson);
		return entityWithLocation(url, person.getEntityId());
	}		

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
