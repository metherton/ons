package com.martinetherton.ons.service;

import com.martinetherton.ons.persist.CensusHouseholdEntryRepository;
import com.martinetherton.ons.persist.CensusHouseholdRepository;
import com.martinetherton.ons.persist.CensusRepository;
import com.martinetherton.ons.persist.LocationRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by martin on 11/12/14.
 */
public class CensusServiceIntegrationTest  extends ServiceIntegrationTest {

    @Autowired
    CensusRepository censusRepository;
    @Autowired
    CensusHouseholdRepository censusHouseholdRepository;
    @Autowired
    CensusHouseholdEntryRepository censusHouseholdEntryRepository;

    @Test
    public void listOfCensuses() {
        CensusService censusService = new CensusServiceImpl(censusRepository,
                                                            censusHouseholdRepository,
                                                            censusHouseholdEntryRepository);
        Assert.assertThat(censusService.getCensuses().size(), Matchers.greaterThan(0));
    }

    @Test
    public void listOfCensusHouseholds() {
        CensusService censusService = new CensusServiceImpl(censusRepository,
                censusHouseholdRepository,
                censusHouseholdEntryRepository);
        Assert.assertThat(censusService.getCensusHouseholds().size(), Matchers.greaterThan(0));
    }

    @Test
    public void listOfCensusHouseholdEntries() {
        CensusService censusService = new CensusServiceImpl(censusRepository,
                censusHouseholdRepository,
                censusHouseholdEntryRepository);
        Assert.assertThat(censusService.getCensusHouseholdEntries().size(), Matchers.greaterThan(0));
    }


}
