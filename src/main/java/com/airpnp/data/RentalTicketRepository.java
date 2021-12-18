package com.airpnp.data;

import com.airpnp.domainmodel.ParkingSpace;
import com.airpnp.domainmodel.RentalTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalTicketRepository extends JpaRepository<RentalTicket, Integer> {

    void deleteRentalTicketById(Integer id);

}