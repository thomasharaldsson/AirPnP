package com.airpnp.service;

import com.airpnp.data.exception.ParkingSpaceNotFoundException;
import com.airpnp.domainmodel.ParkingSpace;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ParkingSpaceMockImpl implements ParkingSpaceService {

    Map<Integer, ParkingSpace> parkingSpaces;

    public ParkingSpaceMockImpl() {
        parkingSpaces = new HashMap<>();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ParkingSpace parkingSpace1 = new ParkingSpace(1, 35, dateFormatter.parse("2020-03-07"), dateFormatter.parse("2020-03-14"), "Götaplatsen 3");
            ParkingSpace parkingSpace2 = new ParkingSpace(2, 40, dateFormatter.parse("2020-01-01"), dateFormatter.parse("2020-01-06"), "Frölunda Torg");
            ParkingSpace parkingSpace3 = new ParkingSpace(3, 15, dateFormatter.parse("2021-02-01"), dateFormatter.parse("2020-03-01"), "Köldgatan");
            ParkingSpace parkingSpace4 = new ParkingSpace(4, 65, dateFormatter.parse("2021-11-02"), dateFormatter.parse("2020-11-29"), "Fryshuset");
            parkingSpaces.put(parkingSpace1.getId(), parkingSpace1);
            parkingSpaces.put(parkingSpace2.getId(), parkingSpace2);
            parkingSpaces.put(parkingSpace3.getId(), parkingSpace3);
            parkingSpaces.put(parkingSpace4.getId(), parkingSpace4);
        } catch (Exception e) {

        }

    }

    @Override
    public ParkingSpace getParkingSpaceById(Long Id) throws ParkingSpaceNotFoundException {
        ParkingSpace parkingSpace = parkingSpaces.get(Id);
        if (parkingSpace == null) {
            throw new ParkingSpaceNotFoundException("There was no parking space with this Id.");
        }
        return parkingSpace;
    }

    @Override
    public List<ParkingSpace> getAllParkingSpaces() {
        return new ArrayList<>(parkingSpaces.values());
    }

    @Override
    public void addParkingSpace(ParkingSpace parkingSpace) {
        parkingSpaces.put(parkingSpace.getId(), parkingSpace);
    }


}
