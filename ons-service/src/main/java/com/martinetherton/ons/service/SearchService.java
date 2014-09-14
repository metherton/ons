package com.martinetherton.ons.service;

import java.util.List;

import com.martinetherton.ons.model.SearchQuery;
import com.martinetherton.ons.model.SearchResult;

public interface SearchService {

	List<SearchResult> search(SearchQuery searchQuery);

}