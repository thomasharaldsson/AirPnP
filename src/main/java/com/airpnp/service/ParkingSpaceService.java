package com.airpnp.service;

import com.airpnp.data.exception.ParkingSpaceNotFoundException;
import com.airpnp.domainmodel.ParkingSpace;

import java.util.List;

public interface ParkingSpaceService {

    ParkingSpace getParkingSpaceById(Integer Id) throws ParkingSpaceNotFoundException;

    List<ParkingSpace> getAllParkingSpaces();

    void updateParkingSpace(ParkingSpace parkingSpace) throws ParkingSpaceNotFoundException;

    void addParkingSpace(ParkingSpace parkingSpace);

    void deleteParkingSpace(int Id) throws ParkingSpaceNotFoundException;

    void deleteAll();
}
