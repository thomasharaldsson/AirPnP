package com.airpnp.data;

import com.airpnp.data.exception.ParkingSpaceNotFoundException;
import com.airpnp.domainmodel.ParkingSpace;

import java.util.List;

public interface ParkingSpaceDao {

    ParkingSpace getParkingSpaceById(Integer id) throws ParkingSpaceNotFoundException;

    List<ParkingSpace> getAllParkingSpaces();

    List<ParkingSpace> getAllAvailableParkingSpaces();

    void updateParkingSpace(ParkingSpace parkingSpace) throws ParkingSpaceNotFoundException;

    void addParkingSpace(ParkingSpace parkingSpace);

    void deleteParkingSpace(int id) throws ParkingSpaceNotFoundException;

    void deleteAll();

}
