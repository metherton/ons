package com.martinetherton.ons.command.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;
import org.springframework.http.HttpStatus;

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
	
	@RequestMapping(value = "/surnames/{surnameId}", method = RequestMethod.GET)
	public @ResponseBody Surname surnameDetails(@PathVariable("surnameId") long id) {
		return surnameService.getSurname(id);
	}		

	@RequestMapping(value = "/surnames", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public HttpEntity<?> createSurname(@RequestBody Surname newSurname,
			@Value("#{request.requestURL}") StringBuffer url) {
		Surname surname = surnameService.add(newSurname);

		return entityWithLocation(url, surname.getEntityId());
	}	

	private HttpEntity<Object> entityWithLocation(StringBuffer url,
			Object resourceId) {
		// Configure and return an HttpEntity object - it will be used to build
		// the HttpServletResponse
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(getLocationForChildResource(url, resourceId));
		return new HttpEntity<Object>(headers);
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
