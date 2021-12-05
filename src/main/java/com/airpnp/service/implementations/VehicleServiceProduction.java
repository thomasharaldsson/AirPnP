package com.airpnp.service.implementations;

import com.airpnp.data.VehicleRepository;
import com.airpnp.data.exception.ParkingSpaceNotFoundException;
import com.airpnp.data.exception.VehicleNotFoundException;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.Vehicle;
import com.airpnp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleServiceProduction implements VehicleService {

    @Autowired
    VehicleRepository data;

    @Override
    public void addVehicle(Vehicle newVehicle) {
        data.save(newVehicle);
    }

    @Override
    public List<Vehicle> getAll() {
        return data.findAll();
        /*
        List<Vehicle> allVehicles = new ArrayList<>();
        Customer c1 = new Customer(3, "Björn", "Jonsson", "njorn@altavista.com", "555-6767");
        Customer c2 = new Customer(2, "George", "Silvant", "gs@france.com", "+99-234-7344");

        allVehicles.add(new Vehicle(4, "ABC-123", c1));
        allVehicles.add(new Vehicle(8, "GZF-223", c2));
        allVehicles.add(new Vehicle(5, "FFF-131", c2));
        return allVehicles;
         */
    }

    @Override
    public Vehicle getVehicleById(Integer id) throws VehicleNotFoundException {
        if (data.findById(id).isPresent()) {
            return data.findById(id).get();
        } else {
            throw new VehicleNotFoundException("There is no vehicle with id = " + id + ".");
        }
    }
}
