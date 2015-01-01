package com.martinetherton.ons.command.rest;

import com.martinetherton.ons.model.*;

import java.util.List;
import java.util.Map;

/**
 * Created by martin on 14/12/14.
 */
public class CensusForm {
    private final Map<Long, List<CensusHouseholdEntry>> censusHouseholdEntries;

    public List<Census> getCensuses() {
        return censuses;
    }

    private final List<Census> censuses;
    private CensusHouseholdEntry addedCensusHouseholdEntry;
    private List<Person> persons;
    private List<Location> locations;

    public CensusForm(Builder builder) {
        this.censusHouseholdEntries = builder.censusHouseholdEntries;
        this.addedCensusHouseholdEntry = builder.addedCensusHouseholdEntry;
        this.persons = builder.persons;
        this.locations = builder.locations;
        this.censuses = builder.censuses;
    }

    public Map<Long, List<CensusHouseholdEntry>> getCensusHouseholdEntries() {
        return censusHouseholdEntries;
    }

    public CensusHouseholdEntry getAddedCensusHouseholdEntry() {
        return addedCensusHouseholdEntry;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public static class Builder {
        private Map<Long, List<CensusHouseholdEntry>> censusHouseholdEntries;
        private CensusHouseholdEntry addedCensusHouseholdEntry;
        private List<Census> censuses;
        private List<Location> locations;
        private List<Person> persons;

        public Builder(Map<Long, List<CensusHouseholdEntry>> censusHouseholdEntries, CensusHouseholdEntry addedCensusHouseholdEntry, List<Census> censuses, List<Location> locations, List<Person> persons) {
            this.censusHouseholdEntries = censusHouseholdEntries;
            this.addedCensusHouseholdEntry = addedCensusHouseholdEntry;
            this.censuses = censuses;
            this.locations = locations;
            this.persons = persons;
        }

        public CensusForm build() {
            return new CensusForm(this);
        }
    }


}


