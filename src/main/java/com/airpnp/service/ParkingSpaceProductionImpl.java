package com.airpnp.service;

import com.airpnp.data.ParkingSpaceRepository;
import com.airpnp.domainmodel.ParkingSpace;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

public class ParkingSpaceProductionImpl implements ParkingSpaceService {

    @Autowired
    private ParkingSpaceRepository data;

    @Override
    public ParkingSpace getParkingSpaceById(Long Id) {
        if (data.findById(Id).isPresent()) {
            return data.findById(Id).get();
        }
        else {
            throw new NoSuchElementException("There was no parking space with this Id.");
        }
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
