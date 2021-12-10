package com.airpnp.data;

import com.airpnp.domainmodel.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // public Customer findByName(String name);
    Customer findByUsername(String username);
}
