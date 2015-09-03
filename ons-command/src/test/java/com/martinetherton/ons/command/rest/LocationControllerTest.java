package com.martinetherton.ons.command.rest;

import com.martinetherton.ons.model.Location;
import com.martinetherton.ons.service.CountryService;
import com.martinetherton.ons.service.LocationService;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertThat;

/**
 * Created by martin on 25/11/14.
 */
public class LocationControllerTest {

    private LocationService locationService;
    private LocationController locationController;
    private CountryService countryService;

    @Before
    public void setUp() {
        locationService = Mockito.mock(LocationService.class);
        countryService = Mockito.mock(CountryService.class);
        locationController = new LocationController(locationService, countryService);
    }

    @Test
    public void getLocations() {
        locationController.getAddLocationForm();
        Mockito.verify(locationService).getLocations();
    }

    @Test
    public void handleLocationRequest() {
        Location location = new Location();
        location.setPostCode("8316PS");
        Mockito.when(locationService.getLocation(1L)).thenReturn(location);

        Location retrievedLocation = locationController.locationDetails(1L);
        assertThat(retrievedLocation.getPostCode(), Matchers.is("8316PS"));
        Mockito.verify(locationService).getLocation(1L);
    }
}
