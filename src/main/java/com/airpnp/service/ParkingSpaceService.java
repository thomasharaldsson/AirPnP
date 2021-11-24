package com.airpnp.service;

import com.airpnp.domainmodel.ParkingSpace;

import java.util.List;

public interface ParkingSpaceService {

    ParkingSpace getParkingSpaceById(int Id);

    List<ParkingSpace> getAllParkingSpaces();

    void addParkingSpace(ParkingSpace parkingSpace);
}
