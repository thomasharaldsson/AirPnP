package com.airpnp.services;

import com.airpnp.domain.ParkingSpace;

import java.util.List;

public interface ParkingSpaceService {

    public ParkingSpace getParkingSpaceById(int Id);

    public List<ParkingSpace> getAllParkingSpaces();
}
