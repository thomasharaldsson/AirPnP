package com.airpnp.service;

import com.airpnp.data.ParkingSpaceRepository;
import com.airpnp.data.exception.ParkingSpaceNotFoundException;
import com.airpnp.domainmodel.ParkingSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Primary
@Component
public class ParkingSpaceProductionImpl implements ParkingSpaceService {

    @Autowired
    private ParkingSpaceRepository data;

    @Override
    public ParkingSpace getParkingSpaceById(Long Id) throws ParkingSpaceNotFoundException {
        if (data.findById(Id).isPresent()) {
            return data.findById(Id).get();
        } else {
            throw new ParkingSpaceNotFoundException("There was no parking space with this Id.");
        }
    }

    @Override
    public List<ParkingSpace> getAllParkingSpaces() {
        return data.findAll();
    }

    @Override
    public void addParkingSpace(ParkingSpace parkingSpace) {
        if (parkingSpace==null) {
            throw new NoSuchElementException("Can not add empty value");
        } else {
            data.save(parkingSpace);
        }
    }
}
