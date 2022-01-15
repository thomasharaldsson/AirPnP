package com.airpnp.service.implementations;

import com.airpnp.data.ParkingSpaceRepository;
import com.airpnp.data.RentalTicketRepository;
import com.airpnp.data.exception.ParkingSpaceNotFoundException;
import com.airpnp.domainmodel.ParkingSpace;
import com.airpnp.service.ParkingSpaceService;
import com.airpnp.service.RentalTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Primary
@Service("parkingSpaceService")
public class ParkingSpaceProductionImpl implements ParkingSpaceService {

    @Autowired
    private ParkingSpaceRepository data;

    @Autowired
    private RentalTicketRepository rentalTicketRepository;

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
        List<ParkingSpace> toReturn = new ArrayList<>();
        for(ParkingSpace p: data.findAll()) {
            if(p.getTicket() == null) {
                toReturn.add(p);
            }
        }
        System.out.println("Getting all parking spaces");
        return toReturn;
    }

    @Override
    public void updateParkingSpace(ParkingSpace parkingSpace) throws ParkingSpaceNotFoundException {
        Integer id = parkingSpace.getId();
        if (!data.existsById(id)) {
            throw new ParkingSpaceNotFoundException("Unable to update space since parkingspace with that id=" + id + " doesn't exist");
        }
        System.out.println("Parking space being updated");
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
    public void deleteParkingSpace(int Id) throws ParkingSpaceNotFoundException {
        data.delete(this.getParkingSpaceById(Id));
    }

    @Override
    public void deleteAll() {
        data.deleteAll();
    }
}
