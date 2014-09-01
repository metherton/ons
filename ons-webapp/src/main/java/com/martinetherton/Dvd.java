package com.martinetherton;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.martinetherton.ons.service.SurnameService;

@Named
//@ManagedBean
@SessionScoped
public class Dvd implements Serializable {
	
	private String genre;
	private List<String> genreList = new ArrayList<String>(Arrays.asList("Pop", "Jazz"));
	private String name = "bla";
	private SurnameService surnameService;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Autowired
	public Dvd(SurnameService surnameService) {
		this.surnameService = surnameService;

	}
	public Dvd() {

	}	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public List<String> getGenreList() {
		return genreList;
	}
	public void setGenreList(List<String> genreList) {
		this.genreList = genreList;
	}
	
}
