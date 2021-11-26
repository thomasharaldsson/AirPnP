package com.airpnp.service.implementations;

import com.airpnp.data.ParkingSpaceRepository;
import com.airpnp.data.exception.ParkingSpaceNotFoundException;
import com.airpnp.domainmodel.ParkingSpace;
import com.airpnp.service.ParkingSpaceService;
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
    public ParkingSpace getParkingSpaceById(Integer id) throws ParkingSpaceNotFoundException {
        if (data.findById(id).isPresent()) {
            return data.findById(id).get();
        } else {
            throw new ParkingSpaceNotFoundException("There is no parking space with id = " + id + ".");
        }
    }

    @Override
    public List<ParkingSpace> getAllParkingSpaces() {
        return data.findAll();
    }

    @Override
    public void updateParkingSpace(ParkingSpace parkingSpace) throws ParkingSpaceNotFoundException {
        Integer id = parkingSpace.getId();
        if (!data.existsById(id)) {
            throw new ParkingSpaceNotFoundException("Unable to update space since parkingspace with that id=" + id + " doesn't exist");
        }
        data.save(parkingSpace);
    }

    @Override
    public void addParkingSpace(ParkingSpace parkingSpace) {
        if (parkingSpace == null) {
            throw new NoSuchElementException("Can not add empty value");
        } else {
            data.save(parkingSpace);
        }
    }

    @Override
    public void deleteParkingspace(Integer id) {
        data.deleteParkingSpacesById(id);
    }




}
