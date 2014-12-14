package com.martinetherton.ons.service;

import com.martinetherton.ons.model.Census;
import com.martinetherton.ons.model.CensusHousehold;
import com.martinetherton.ons.model.CensusHouseholdEntry;
import com.martinetherton.ons.persist.CensusHouseholdEntryRepository;
import com.martinetherton.ons.persist.CensusHouseholdRepository;
import com.martinetherton.ons.persist.CensusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by martin on 11/12/14.
 */
@Service
@Transactional(timeout=60)
public class CensusServiceImpl implements CensusService {
    private CensusRepository censusRepository;
    private CensusHouseholdRepository censusHouseholdRepository;
    private CensusHouseholdEntryRepository censusHouseholdEntryRepository;

    @Autowired
    public CensusServiceImpl(CensusRepository censusRepository,
                             CensusHouseholdRepository censusHouseholdRepository,
                             CensusHouseholdEntryRepository censusHouseholdEntryRepository) {
        this.censusRepository = censusRepository;
        this.censusHouseholdRepository = censusHouseholdRepository;
        this.censusHouseholdEntryRepository = censusHouseholdEntryRepository;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Census> getCensuses() {
        return censusRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public List<CensusHousehold> getCensusHouseholds() {
        return censusHouseholdRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public List<CensusHouseholdEntry> getCensusHouseholdEntries() {
        return censusHouseholdEntryRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Map<Long, List<CensusHouseholdEntry>> getCensusToCensusHouseholdEntryMap() {
        Map<Long, List<CensusHouseholdEntry>> censusEntries = new HashMap<Long, List<CensusHouseholdEntry>>();
        List<Census> censuses = censusRepository.findAll();
        for (Census census : censuses) {
            Long year = census.getYear();
            List<CensusHouseholdEntry> entries = censusHouseholdEntryRepository.findAllEntriesFor(year);
            censusEntries.put(year, entries);
        }
        return censusEntries;
    }
}
