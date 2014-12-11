package com.martinetherton.ons.command.rest;

import com.martinetherton.ons.service.CountryService;
import com.martinetherton.ons.service.LocationService;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by martin on 25/11/14.
 */
public class LocationControllerTest {

    @Test
    public void getLocations() {
        LocationService locationService;
        CountryService countryService;
        locationService = Mockito.mock(LocationService.class);
        countryService = Mockito.mock(CountryService.class);

        LocationController locationController = new LocationController(locationService, countryService);

        locationController.getAddLocationForm();

        Mockito.verify(locationService).getLocations();
    }
}
