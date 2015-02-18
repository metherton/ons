package com.martinetherton.ons.service;

import com.martinetherton.ons.model.CensusHouseholdEntry;
import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.persist.CensusHouseholdEntryRepository;
import com.martinetherton.ons.persist.CensusHouseholdEntryRepositoryImpl;
import com.martinetherton.ons.persist.PersonRepositoryImpl;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import org.junit.Before;

/**
 * Created by martin on 18/02/15.
 */
public class CensusServiceImplTest {

    private CensusHouseholdEntryRepository censusHouseholdEntryRepository;
    private CensusService censusService;

    @Before
    public void setUp() {
        censusHouseholdEntryRepository = Mockito.mock(CensusHouseholdEntryRepositoryImpl.class);
        censusService = new CensusServiceImpl(null,null,censusHouseholdEntryRepository);
    }


    @Test
    public void shouldCallRepositoryGetHouseholdEntry() {

        CensusHouseholdEntry entry = new CensusHouseholdEntry();
        Person person = new Person();
        person.setFirstName("John");
        entry.setPerson(person);

        when(censusHouseholdEntryRepository.findBy(1L)).thenReturn(entry);

        censusService.getCensusHouseholdEntry(1L);

        verify(censusHouseholdEntryRepository).findBy(1L);
    }
}
