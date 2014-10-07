package com.martinetherton.ons.service;

import java.util.List;

import com.martinetherton.ons.model.Surname;

public interface SurnameService {

    Surname getSurname(Long id);

    List<Surname> getSurnames();

    Surname getSurnameWithName(String name);

    Surname add(Surname newSurname);

    void update(Surname changedSurname);

}
