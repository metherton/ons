package com.martinetherton.ons.command.rest;

import com.martinetherton.ons.model.*;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martin on 27/11/14.
 */
public class LocationsFormBuilderTest {

    @Test
    public void addLocationFormBuilderShouldBuildForm() {
        List<Location> locations = new ArrayList<Location>();
        locations.add(new Location());
        locations.add(new Location());
        Location addedLocation = new Location();
        List<Country> countries = new ArrayList<Country>();
        countries.add(new Country());
        countries.add(new Country());
        LocationsForm locationsForm = new LocationsForm.Builder(locations, addedLocation, countries).build();
        Assert.assertThat(locationsForm.getLocations().size(), Matchers.is(2));
        Assert.assertThat(locationsForm.getAddedLocation(), Matchers.is(addedLocation));
    }


}
