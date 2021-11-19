package com.airpnp.AirPnP.data;

import com.airpnp.AirPnP.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
   // public Customer findByName(String name);
}
