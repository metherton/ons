package com.martinetherton.ons.model;

import javax.persistence.*;

/**
 * Created by martin on 08/12/14.
 */
@Entity
@Table(name="T_CENSUS_HOUSEHOLD")
public class CensusHousehold {

    public Long getEntityId() {
        return entityId;
    }

    @Id
    @Column(name="ID")
    @GeneratedValue
    private Long entityId;

    @ManyToOne
    @JoinColumn(name="CENSUS_ID")
    private Census census;

    @ManyToOne
    @JoinColumn(name="LOCATION_ID")
    private Location location;

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public void setCensus(Census census) {
        this.census = census;
    }

    public Census getCensus() {
        return census;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
