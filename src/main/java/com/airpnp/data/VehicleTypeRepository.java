package com.airpnp.data;

import com.airpnp.domainmodel.Vehicle;
import com.airpnp.domainmodel.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer>  {
}
