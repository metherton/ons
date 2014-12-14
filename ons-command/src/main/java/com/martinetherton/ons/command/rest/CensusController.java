package com.martinetherton.ons.command.rest;

import com.martinetherton.ons.model.CensusHouseholdEntry;
import com.martinetherton.ons.model.Surname;
import com.martinetherton.ons.service.CensusService;
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
import java.util.Map;

/**
 * Created by martin on 14/12/14.
 */
@Controller
public class CensusController {

    private CensusService censusService;

    @Autowired
    public CensusController(CensusService censusService) {
        this.censusService = censusService;
    }

    @RequestMapping(value = "/censuses", method = RequestMethod.GET)
    public @ResponseBody CensusForm getCensuses() {
        CensusForm form = new CensusForm.Builder(censusService.getCensusToCensusHouseholdEntryMap()).build();
        return form;
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
