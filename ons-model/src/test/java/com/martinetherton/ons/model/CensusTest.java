package com.martinetherton.ons.model;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by martin on 08/12/14.
 */
public class CensusTest {

    @Test
    public void settersAndGetters() {
        Census census = new Census();
        census.setEntityId(1L);
        census.setYear(1901L);
        Country country = new Country();
        census.setCountry(country);
        assertThat(census.getEntityId(), Matchers.is(1L));
        assertThat(census.getYear(), Matchers.is(1901L));
        assertThat(census.getCountry(), Matchers.is(country));
    }
}
