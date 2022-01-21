package com.airpnp.service.implementations;

import com.airpnp.data.VehicleDao;
import com.airpnp.data.repository.VehicleRepository;
import com.airpnp.data.exception.VehicleNotFoundException;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.Vehicle;
import com.airpnp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("vehicleService")
public class VehicleServiceProduction implements VehicleService {

    @Autowired
    VehicleDao data;

    @Override
    public void addVehicle(Vehicle newVehicle) {
        data.addVehicle(newVehicle);
    }

    @Override
    public List<Vehicle> getAll() {
        return data.getAll();
    }

    @Override
    public List<Vehicle> getAll(Customer customer) {
        return data.getAll(customer);
    }

    @Override
    public Vehicle getVehicleById(Integer id) throws VehicleNotFoundException {
        return data.getVehicleById(id);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) throws VehicleNotFoundException {
        data.updateVehicle(vehicle);
    }

    @Override
    public void deleteVehicle(int id) throws VehicleNotFoundException {
        data.deleteVehicle(id);
    }

    @Override
    public void deleteAll() {
        data.deleteAll();
    }
}
