package com.airpnp.data;

import com.airpnp.domainmodel.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
   // public Customer findByName(String name);
}
