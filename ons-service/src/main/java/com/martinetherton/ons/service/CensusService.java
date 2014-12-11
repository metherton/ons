package com.martinetherton.ons.service;

import com.martinetherton.ons.model.Census;
import com.martinetherton.ons.model.CensusHousehold;
import com.martinetherton.ons.model.CensusHouseholdEntry;

import java.util.List;

/**
 * Created by martin on 11/12/14.
 */
public interface CensusService {
    List<Census> getCensuses();

    List<CensusHousehold> getCensusHouseholds();

    List<CensusHouseholdEntry> getCensusHouseholdEntries();
}
