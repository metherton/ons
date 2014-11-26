package com.martinetherton.ons.model;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class LocationTest {

    @Test
    public void locationConstructor() {
        Location location = new Location("Sheffield");
        location.setPostCode("S17");
        location.setAddressLine1("First address line");
        location.setAddressLine2("Second address line");
//        Country country = new Country();
//        country.setCode('uk')
//        location.setCountry(66L);
        Assert.assertThat("Sheffield", Matchers.is(location.getCity()));
        Assert.assertThat("S17", Matchers.is(location.getPostCode()));
    }
    
}
