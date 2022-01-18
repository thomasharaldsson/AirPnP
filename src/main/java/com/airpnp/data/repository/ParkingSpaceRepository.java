package com.airpnp.data.repository;

import com.airpnp.domainmodel.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Integer> {
    void deleteParkingSpacesById(Integer id);
}