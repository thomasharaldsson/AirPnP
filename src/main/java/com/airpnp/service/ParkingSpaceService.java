package com.airpnp.service;

import com.airpnp.domainmodel.ParkingSpace;

import java.util.List;

public interface ParkingSpaceService {

    public ParkingSpace getParkingSpaceById(int Id);

    public List<ParkingSpace> getAllParkingSpaces();

    public void addParkingSpace(ParkingSpace parkingSpace);
}
