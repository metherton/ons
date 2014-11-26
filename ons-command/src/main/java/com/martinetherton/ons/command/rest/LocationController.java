package com.martinetherton.ons.command.rest;

import com.martinetherton.ons.model.Location;
import com.martinetherton.ons.service.LocationService;
import com.martinetherton.ons.service.SurnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LocationController {

    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public @ResponseBody List<Location> getLocations() {
        return locationService.getLocations();
    }
}
