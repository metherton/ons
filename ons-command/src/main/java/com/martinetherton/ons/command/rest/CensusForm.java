package com.martinetherton.ons.command.rest;

import com.martinetherton.ons.model.CensusHouseholdEntry;
import com.martinetherton.ons.model.Surname;

import java.util.List;
import java.util.Map;

/**
 * Created by martin on 14/12/14.
 */
public class CensusForm {
    private final Map<Long, List<CensusHouseholdEntry>> censuses;

    public CensusForm(Builder builder) {
        this.censuses = builder.censuses;
    }

    public Map<Long, List<CensusHouseholdEntry>> getCensuses() {
        return censuses;
    }

    public static class Builder {
        public Map<Long, List<CensusHouseholdEntry>> censuses;

        public Builder(Map<Long, List<CensusHouseholdEntry>> censuses) {
            this.censuses = censuses;
        }

        public CensusForm build() {
            return new CensusForm(this);
        }
    }


}


