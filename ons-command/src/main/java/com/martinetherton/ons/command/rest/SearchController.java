package com.martinetherton.ons.command.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.martinetherton.ons.model.SearchCriteria;
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
	
}
