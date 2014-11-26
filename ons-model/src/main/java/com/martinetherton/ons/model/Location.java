package com.martinetherton.ons.model;

import javax.persistence.*;


@Entity
@Table(name="T_LOCATION")
public class Location {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long entityId;
    @Column(name="CITY")
    private String city;
    @Column(name="POST_CODE")
    private String postCode;
    @Column(name="ADDRESS_LINE_1")
    private String addressLine1;
    @Column(name="ADDRESS_LINE_2")
    private String addressLine2;
    @OneToOne
    @JoinColumn(name="COUNTRY_ID")
    private Country country;

    public Location() {};

    public Location(String city) {
        this.city = city;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
