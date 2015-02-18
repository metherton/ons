package com.martinetherton.ons.command.rest;

import com.martinetherton.ons.model.Census;
import com.martinetherton.ons.model.CensusHouseholdEntry;
import com.martinetherton.ons.service.CensusService;
import com.martinetherton.ons.service.CensusServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by martin on 18/02/15.
 */
public class CensusControllerTest {

    private CensusController censusController;
    private CensusService censusService;

    @Before
    public void setUp() {
        censusService = Mockito.mock(CensusServiceImpl.class);
        censusController = new CensusController(censusService, null, null);
    }

    @Test
    public void getCensusHouseholdEntry() {

        CensusHouseholdEntry censusHouseholdEntry = new CensusHouseholdEntry();
        Mockito.when(censusService.getCensusHouseholdEntry(1L)).thenReturn(censusHouseholdEntry);

        censusController.censusHouseholdEntryDetails(1L);

        Mockito.verify(censusService).getCensusHouseholdEntry(1L);

    }
}
