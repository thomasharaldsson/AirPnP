package com.airpnp.data;

import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.Lender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LenderRepository extends JpaRepository<Lender, Integer> {
    Lender findByUsername(String username);
}
