package com.martinetherton.ons.service;

import com.martinetherton.ons.model.CensusHouseholdEntry;
import com.martinetherton.ons.persist.CensusHouseholdEntryRepository;
import com.martinetherton.ons.persist.CensusHouseholdRepository;
import com.martinetherton.ons.persist.CensusRepository;
import com.martinetherton.ons.persist.LocationRepository;
import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by martin on 11/12/14.
 */
public class CensusServiceIntegrationTest  extends ServiceIntegrationTest {

    @Autowired
    CensusService censusService;

    @Test
    public void listOfCensuses() {
        Assert.assertThat(censusService.getCensuses().size(), Matchers.greaterThan(0));
    }

    @Test
    public void listOfCensusHouseholds() {
        Assert.assertThat(censusService.getCensusHouseholds().size(), Matchers.greaterThan(0));
    }

    @Test
    public void listOfCensusHouseholdEntries() {
        Assert.assertThat(censusService.getCensusHouseholdEntries().size(), Matchers.greaterThan(0));
    }

    @Test
    public void getCensusMappedToEntries() {
        Map<Long, List<CensusHouseholdEntry>> censusEntries = censusService.getCensusToCensusHouseholdEntryMap();
        Assert.assertThat(censusEntries.size(), Matchers.greaterThan(0));
    }


}
