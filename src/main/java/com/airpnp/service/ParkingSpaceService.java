package com.airpnp.service;

import com.airpnp.domainmodel.ParkingSpace;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSpaceService {

    public ParkingSpace getParkingSpaceById(int Id);

    public List<ParkingSpace> getAllParkingSpaces();

    public void addParkingSpace(ParkingSpace parkingSpace);
}
