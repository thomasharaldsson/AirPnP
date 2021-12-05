package com.airpnp.service;

import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.Vehicle;

import java.util.List;

public interface VehicleService {
    void addVehicle(Vehicle newVehicle);
    List<Vehicle> getAll();
}
