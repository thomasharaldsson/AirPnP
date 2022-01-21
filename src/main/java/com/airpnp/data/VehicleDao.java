package com.airpnp.data;

import com.airpnp.data.exception.VehicleNotFoundException;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.Vehicle;

import java.util.List;

public interface VehicleDao {
    void addVehicle(Vehicle newVehicle);

    List<Vehicle> getAll();

    List<Vehicle> getAll(Customer customer);

    Vehicle getVehicleById(Integer id) throws VehicleNotFoundException;

    void updateVehicle(Vehicle vehicle) throws VehicleNotFoundException;

    void deleteVehicle(int id) throws VehicleNotFoundException;

    void deleteAll();
}
