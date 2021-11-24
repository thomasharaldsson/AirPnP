package com.airpnp.service;

import com.airpnp.data.ParkingSpaceRepository;
import com.airpnp.domainmodel.ParkingSpace;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ParkingSpaceProductionImpl implements ParkingSpaceService {

    @Autowired
    private ParkingSpaceRepository data;

    @Override
    public ParkingSpace getParkingSpaceById(Long Id) {
        return data.findById(Id).get();
    }

    @Override
    public List<ParkingSpace> getAllParkingSpaces() {
        return data.findAll();
    }

    @Override
    public void addParkingSpace(ParkingSpace parkingSpace) {
        // TODO: Implement method
    }
}
