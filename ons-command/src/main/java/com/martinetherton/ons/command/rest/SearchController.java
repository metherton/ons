package com.martinetherton.ons.command.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.martinetherton.ons.model.SearchCriteria;
import com.martinetherton.ons.model.SearchQuery;
import com.martinetherton.ons.model.SearchResult;
import com.martinetherton.ons.model.Surname;
import com.martinetherton.ons.service.SearchService;

@Controller
public class SearchController {

	private SearchService searchService;	
	
	@Autowired
	public SearchController(SearchService searchService) {
		this.searchService = searchService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody SearchCriteria searchCritera() {
		return searchService.searchCriteria();
	}		

	@RequestMapping(value = "/search/surname/{surname}", method = RequestMethod.GET)
	public @ResponseBody List<SearchResult> search(@PathVariable("surname") String surname) {
		SearchQuery query = new SearchQuery();
		Surname newSurname = new Surname();
		newSurname.setSurname(surname);
		query.setSurname(newSurname);
		return searchService.search(query);
	}	
	
	
	
}
