package com.airpnp.service;

import com.airpnp.data.exception.VehicleNotFoundException;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.Vehicle;

import java.util.List;

public interface VehicleService {
    void addVehicle(Vehicle newVehicle);
    List<Vehicle> getAll();

    Vehicle getVehicleById(Integer valueOf) throws VehicleNotFoundException;

    void updateVehicle(Vehicle vehicle) throws VehicleNotFoundException;

    void deleteVehicle(int id) throws VehicleNotFoundException;

    void deleteAll();
}
