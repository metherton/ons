package com.martinetherton.ons.command.rest;

import com.martinetherton.ons.model.*;
import com.martinetherton.ons.service.CensusService;
import com.martinetherton.ons.service.LocationService;
import com.martinetherton.ons.service.PersonService;
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

/**
 * Created by martin on 14/12/14.
 */
@Controller
public class CensusController {

    private CensusService censusService;
    private LocationService locationService;
    private PersonService personService;

    @Autowired
    public CensusController(CensusService censusService, LocationService locationService, PersonService personService) {
        this.censusService = censusService;
        this.locationService = locationService;
        this.personService = personService;
    }

    @RequestMapping(value = "/censuses", method = RequestMethod.GET)
    public @ResponseBody CensusForm getCensuses() {
        CensusHouseholdEntry addedCensusHouseholdEntry = new CensusHouseholdEntry();
        List<Census> censuses = censusService.getCensuses();
        List<Location> locations = locationService.getLocations();
        List<Person> persons = personService.getPersons();
        CensusForm form = new CensusForm.Builder(censusService.getCensusToCensusHouseholdEntryMap(), addedCensusHouseholdEntry, censuses, locations, persons).build();
        return form;
    }

    @RequestMapping(value = "/censuses", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public HttpEntity<String> createCensusHouseholdEntry(@RequestBody CensusHouseholdEntry newCensusHouseholdEntry,
                                             @Value("#{request.requestURL}") StringBuffer url) {
        CensusHousehold censusHousehold = censusService.findCensusHousehold(newCensusHouseholdEntry.getCensusHousehold().getCensus(), newCensusHouseholdEntry.getCensusHousehold().getLocation());
        if (censusHousehold == null) {
            censusHousehold = censusService.addCensusHousehold(newCensusHouseholdEntry.getCensusHousehold());
        }
        newCensusHouseholdEntry.setCensusHousehold(censusHousehold);
        CensusHouseholdEntry censusHouseholdEntry = censusService.addCensusHouseholdEntry(newCensusHouseholdEntry);
        return entityWithLocation(url, censusHouseholdEntry.getEntityId());
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

}
