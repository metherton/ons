package com.martinetherton.ons.model;

import org.junit.Test;

/**
 * Created by martin on 08/12/14.
 */
public class CensusHouseholdTest {

    @Test
    public void settersAndGetters() {
        CensusHousehold censusHousehold = new CensusHousehold();
        censusHousehold.setEntityId(1L);
        Census census = new Census();
        Location location = new Location();
        censusHousehold.setCensus(census);
        censusHousehold.setLocation(location);
    }
}
