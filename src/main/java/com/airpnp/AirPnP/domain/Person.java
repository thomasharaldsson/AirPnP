package com.airpnp.AirPnP.domain;

import com.airpnp.AirPnP.service.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Person extends JpaRepository<Customer, Long> {
    String getName();
    void setName(String name);
    String getID();
    void setID(String ID);
}
