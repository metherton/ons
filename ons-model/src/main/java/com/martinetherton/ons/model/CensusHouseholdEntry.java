package com.martinetherton.ons.model;

import javax.persistence.*;

/**
 * Created by martin on 11/12/14.
 */
@Entity
@Table(name="T_CENSUS_HOUSEHOLD_ENTRY")
public class CensusHouseholdEntry {

    @Id
    @Column(name="ID")
    @GeneratedValue
    private Long entityId;

    @ManyToOne
    @JoinColumn(name="CENSUS_HOUSEHOLD_ID")
    private CensusHousehold censusHousehold;

    @ManyToOne
    @JoinColumn(name="PERSON_ID")
    private Person person;

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setCensusHousehold(CensusHousehold censusHousehold) {
        this.censusHousehold = censusHousehold;
    }

    public CensusHousehold getCensusHousehold() {
        return censusHousehold;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    public Person getPerson() {
        return person;
    }
}
