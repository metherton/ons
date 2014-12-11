package com.martinetherton.ons.service;

import com.martinetherton.ons.model.Country;
import com.martinetherton.ons.persist.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(timeout=60)
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    public CountryServiceImpl() {

    }

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }
}
