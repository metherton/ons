package com.martinetherton.ons.command.rest;

import com.martinetherton.ons.model.*;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by martin on 28/12/14.
 */
public class CensusHouseholdEntryFormBuilderTest {

    @Test
    public void addCensusHouseholdEntryFormBuilderShouldBuildForm() {
        Map<Long, List<CensusHouseholdEntry>> censusHouseholdEntries = new HashMap<Long, List<CensusHouseholdEntry>>();
        Census census = new Census();
        List<CensusHouseholdEntry> entries = new ArrayList<CensusHouseholdEntry>();
        censusHouseholdEntries.put(1841L, entries);
        censusHouseholdEntries.put(1851L, entries);
        List<Census> censuses = new ArrayList<Census>();
        censuses.add(new Census());
        censuses.add(new Census());
        List<Location> locations = new ArrayList<Location>();
        List<Person> persons = new ArrayList<Person>();
        CensusHouseholdEntry addedCensusHouseholdEntry = new CensusHouseholdEntry();
        CensusForm censusForm = new CensusForm.Builder(censusHouseholdEntries, addedCensusHouseholdEntry, censuses, locations, persons).build();
        Assert.assertThat(censusForm.getCensusHouseholdEntries().size(), Matchers.is(2));
        Assert.assertThat(censusForm.getAddedCensusHouseholdEntry(), Matchers.is(addedCensusHouseholdEntry));
        Assert.assertThat(censusForm.getPersons(), Matchers.is(persons));
        Assert.assertThat(censusForm.getLocations(), Matchers.is(locations));
    }

}
