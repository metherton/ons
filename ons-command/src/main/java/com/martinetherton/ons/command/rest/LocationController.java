package com.martinetherton.ons.command.rest;

import com.martinetherton.ons.model.Location;
import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.model.PersonDetails;
import com.martinetherton.ons.service.CountryService;
import com.martinetherton.ons.service.LocationService;
import com.martinetherton.ons.service.SurnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.List;

@Controller
public class LocationController {

    private LocationService locationService;
    private CountryService countryService;

    @Autowired
    public LocationController(LocationService locationService, CountryService countryService) {
        this.locationService = locationService;
        this.countryService = countryService;
    }

    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public @ResponseBody LocationsForm getAddLocationForm() {
        return new LocationsForm.Builder(locationService.getLocations(),new Location(), countryService.getCountries()).build();
    }

    @RequestMapping(value = "/locations", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public HttpEntity<String> createLocation(@RequestBody Location newLocation,
                                           @Value("#{request.requestURL}") StringBuffer url) {
        Location location = locationService.addLocation(newLocation);
        return entityWithLocation(url, location.getEntityId());
    }
    private HttpEntity<String> entityWithLocation(StringBuffer url,
                                                  Object resourceId) {
        // Configure and return an HttpEntity object - it will be used to build
        // the HttpServletResponse
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(getLocationForChildResource(url, resourceId));
        return new HttpEntity<String>(headers);
    }

    /**
     * determines URL of child resource based on the full URL of the given
     * request, appending the path info with the given childIdentifier using a
     * UriTemplate.
     */
    private URI getLocationForChildResource(StringBuffer url,
                                            Object childIdentifier) {
        UriTemplate template = new UriTemplate(url.append("/{childId}")
                .toString());
        return template.expand(childIdentifier);
    }


    @RequestMapping(value = "/locations/{locationId}", method = RequestMethod.GET)
    public @ResponseBody Location locationDetails(@PathVariable("locationId") long id) {
        return locationService.getLocation(id);
    }
}
