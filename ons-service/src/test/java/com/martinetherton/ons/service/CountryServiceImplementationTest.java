package com.martinetherton.ons.service;

import com.martinetherton.ons.persist.CountryRepository;
import com.martinetherton.ons.persist.LocationRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by martin on 26/11/14.
 */
public class CountryServiceImplementationTest extends ServiceIntegrationTest {

    @Autowired
    CountryRepository countryRepository;

    @Test
    public void countriesRetrieved() {
        CountryService countryService = new CountryServiceImpl(countryRepository);
        Assert.assertThat(countryService.getCountries().size(), Matchers.is(Matchers.greaterThan(0)));
    }


}
