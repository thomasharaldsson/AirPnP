package com.airpnp.service;

import com.airpnp.data.exception.VehicleTypeNotFoundException;
import com.airpnp.domainmodel.Vehicle;
import com.airpnp.domainmodel.VehicleType;

import java.util.List;

public interface VehicleTypeService {
    void add(VehicleType vehicleType);

    List<VehicleType> getAll();
    void deleteAll();
    VehicleType getVehicleTypeById(Integer vehicleTypeId) throws VehicleTypeNotFoundException;
}
