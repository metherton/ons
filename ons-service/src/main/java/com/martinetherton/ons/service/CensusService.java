package com.martinetherton.ons.service;

import com.martinetherton.ons.model.Census;
import com.martinetherton.ons.model.CensusHousehold;
import com.martinetherton.ons.model.CensusHouseholdEntry;
import com.martinetherton.ons.model.Location;

import java.util.List;
import java.util.Map;

/**
 * Created by martin on 11/12/14.
 */
public interface CensusService {
    List<Census> getCensuses();

    List<CensusHousehold> getCensusHouseholds();

    List<CensusHouseholdEntry> getCensusHouseholdEntries();

    Map<Long, List<CensusHouseholdEntry>> getCensusToCensusHouseholdEntryMap();

    CensusHouseholdEntry addCensusHouseholdEntry(CensusHouseholdEntry censusHouseholdEntry);

    CensusHousehold findCensusHousehold(Census census, Location location);

    CensusHousehold addCensusHousehold(CensusHousehold censusHousehold);

    CensusHouseholdEntry getCensusHouseholdEntry(long id);

}
