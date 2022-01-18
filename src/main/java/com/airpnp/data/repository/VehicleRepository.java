package com.airpnp.data.repository;

import com.airpnp.domainmodel.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
