package com.martinetherton.ons.model;

import javax.persistence.*;


@Entity
@Table(name="T_CENSUS")
public class Census {

    @Column(name="YEAR")
    private Long year;

    @ManyToOne
    @JoinColumn(name="COUNTRY_ID")
    private Country country;

    @Id
    @Column(name="ID")
    @GeneratedValue
    private Long entityId;

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getYear() {
        return year;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public Long getEntityId() {
        return entityId;
    }
}
