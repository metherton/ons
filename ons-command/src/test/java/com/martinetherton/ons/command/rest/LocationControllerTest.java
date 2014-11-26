package com.martinetherton.ons.command.rest;

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
        locationService = Mockito.mock(LocationService.class);
        LocationController locationController = new LocationController(locationService);

        locationController.getLocations();

        Mockito.verify(locationService).getLocations();
    }
}
