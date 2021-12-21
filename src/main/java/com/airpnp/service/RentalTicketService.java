package com.airpnp.service;

import com.airpnp.data.exception.ParkingSpaceNotFoundException;
import com.airpnp.domainmodel.ParkingSpace;
import com.airpnp.domainmodel.RentalTicket;

import java.util.List;

public interface RentalTicketService {
    List<RentalTicket> getAllRentalTickets();
    void addRentalTicket(RentalTicket rentalTicket) throws ParkingSpaceNotFoundException;
    void deleteAll();
}
