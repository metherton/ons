package com.martinetherton.ons.model;

import org.junit.Test;

/**
 * Created by martin on 08/12/14.
 */
public class CensusHouseholdEntryTest {

    @Test
    public void settersAndGetters() {
       CensusHouseholdEntry entry = new CensusHouseholdEntry();
       entry.setEntityId(1L);
       CensusHousehold household = new CensusHousehold();
       Person person = new Person();
       entry.setCensusHousehold(household);
       entry.setPerson(person);
    }
}
