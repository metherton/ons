package com.martinetherton.ons.model;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by martin on 25/11/14.
 */
public class CountryTest {

    @Test
    public void countryConstructor() {
        Country country = new Country();
        country.setCode("nl");
        country.setName("Netherlands");
        Assert.assertThat("nl", Matchers.is(country.getCode()));
        Assert.assertThat("Netherlands", Matchers.is(country.getName()));
    }


}
