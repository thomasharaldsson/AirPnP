package com.airpnp.service;

import com.airpnp.data.ParkingSpaceRepository;
import com.airpnp.domainmodel.ParkingSpace;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ParkingSpaceProductionImplementation implements ParkingSpaceService {

    @Autowired
    private ParkingSpaceRepository data;

    @Override
    public ParkingSpace getParkingSpaceById(int Id) {
        // TODO: Implement method
        return null;
    }

    @Override
    public List<ParkingSpace> getAllParkingSpaces() {
        // TODO: Implement method
        return null;
    }

    @Override
    public void addParkingSpace(ParkingSpace parkingSpace) {
        // TODO: Implement method
    }
}
