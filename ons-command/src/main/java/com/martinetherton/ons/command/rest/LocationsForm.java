package com.martinetherton.ons.command.rest;

import com.martinetherton.ons.model.Country;
import com.martinetherton.ons.model.Location;

import java.util.List;

/**
 * Created by martin on 27/11/14.
 */
public class LocationsForm {
    private final List<Location> locations;
    private final List<Country> countries;
    private Location addedLocation;

    public List<Country> getCountries() {
        return countries;
    }

    public LocationsForm(Builder builder) {
        this.addedLocation = builder.addedLocation;
        this.locations = builder.locations;
        this.countries = builder.countries;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public Location getAddedLocation() {
        return addedLocation;
    }

    public static class Builder {
        private final List<Location> locations;
        private final Location addedLocation;
        private final List<Country> countries;

        public Builder(List<Location> locations, Location addedLocation, List<Country> countries) {
            this.locations = locations;
            this.addedLocation = addedLocation;
            this.countries = countries;
        }

        public LocationsForm build() {
            return new LocationsForm(this);
        }
    }
}
