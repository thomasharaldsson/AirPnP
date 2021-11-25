package com.airpnp.service;

import com.airpnp.data.exception.ParkingSpaceNotFoundException;
import com.airpnp.domainmodel.ParkingSpace;

import java.util.List;

public interface ParkingSpaceService {

    ParkingSpace getParkingSpaceById(Long Id) throws ParkingSpaceNotFoundException;

    List<ParkingSpace> getAllParkingSpaces();

    void addParkingSpace(ParkingSpace parkingSpace);
}
