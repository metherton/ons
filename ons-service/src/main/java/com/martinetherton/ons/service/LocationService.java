package com.martinetherton.ons.service;

import com.martinetherton.ons.model.Location;

import java.util.List;

public interface LocationService {

    Location getLocation(long id);

    List<Location> getLocations();
}
