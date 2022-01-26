package com.airpnp.service.implementations;

import com.airpnp.data.repository.VehicleTypeRepository;
import com.airpnp.data.exception.VehicleTypeNotFoundException;
import com.airpnp.domainmodel.VehicleType;
import com.airpnp.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleTypeProduction implements VehicleTypeService {

    @Autowired
    VehicleTypeRepository data;

    @Override
    public void add(VehicleType vehicleType) {
        data.save(vehicleType);
    }

    @Override
    public List<VehicleType> getAll() {
        return data.findAll();
    }

    @Override
    public void deleteAll() {
        data.deleteAll();
    }

    @Override
    public VehicleType getVehicleTypeById(Integer vehicleTypeId) throws VehicleTypeNotFoundException {
        if (data.findById(vehicleTypeId).isPresent()) {
            return data.findById(vehicleTypeId).get();
        } else {
            throw new VehicleTypeNotFoundException("There is no vehicle type with id = " + vehicleTypeId + ".");
        }
    }
}
