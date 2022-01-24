package com.airpnp.service.implementations;

import com.airpnp.data.exception.ParkingSpaceNotFoundException;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.ParkingSpace;
import com.airpnp.service.ParkingSpaceService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("parkingSpaceServiceMock")
public class ParkingSpaceMockImpl implements ParkingSpaceService {

    Map<Integer, ParkingSpace> parkingSpaces;

    public ParkingSpaceMockImpl() {
        parkingSpaces = new HashMap<>();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ParkingSpace parkingSpace1 = new ParkingSpace(35, dateFormatter.parse("2020-03-07"), dateFormatter.parse("2020-03-14"), "Götaplatsen 3", null);
            parkingSpace1.setId(1);
            ParkingSpace parkingSpace2 = new ParkingSpace(40, dateFormatter.parse("2020-01-01"), dateFormatter.parse("2020-01-06"), "Frölunda Torg", null);
            parkingSpace2.setId(2);
            ParkingSpace parkingSpace3 = new ParkingSpace(15, dateFormatter.parse("2021-02-01"), dateFormatter.parse("2020-03-01"), "Köldgatan", null);
            parkingSpace3.setId(3);
            ParkingSpace parkingSpace4 = new ParkingSpace(65, dateFormatter.parse("2021-11-02"), dateFormatter.parse("2020-11-29"), "Fryshuset", null);
            parkingSpace4.setId(4);
            parkingSpaces.put(parkingSpace1.getId(), parkingSpace1);
            parkingSpaces.put(parkingSpace2.getId(), parkingSpace2);
            parkingSpaces.put(parkingSpace3.getId(), parkingSpace3);
            parkingSpaces.put(parkingSpace4.getId(), parkingSpace4);
        } catch (Exception e) {

        }

    }

    @Override
    public ParkingSpace getParkingSpaceById(Integer Id) throws ParkingSpaceNotFoundException {
        ParkingSpace parkingSpace = parkingSpaces.get(Id);
        if (parkingSpace == null) {
            throw new ParkingSpaceNotFoundException("There was no parking space with this Id.");
        }
        return parkingSpaces.get(Id);
    }

    @Override
    public List<ParkingSpace> getAllParkingSpaces() {
        return new ArrayList<>(parkingSpaces.values());
    }

    @Override
    public List<ParkingSpace> getAllAvailableParkingSpaces() {
        return null;
    }

    @Override
    public void updateParkingSpace(ParkingSpace parkingSpace) throws ParkingSpaceNotFoundException {
        //TODO: implement method.
    }

    @Override
    public void addParkingSpace(ParkingSpace parkingSpace) {
        parkingSpaces.put(parkingSpace.getId(), parkingSpace);
    }

    @Override
    public void deleteParkingSpace(int Id) {

    }

    @Override
    public void deleteAll() {
        parkingSpaces.clear();
    }

    @Override
    public List<ParkingSpace> getAllParkingSpaces(Customer selectedCustomer) {
        return null;
    }

}
