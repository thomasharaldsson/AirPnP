package com.airpnp.service;

import com.airpnp.data.exception.ParkingSpaceNotFoundException;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.RentalTicket;

import java.util.List;

public interface RentalTicketService {
    List<RentalTicket> getAllRentalTicketsCurrentUser();
    void addRentalTicket(RentalTicket rentalTicket) throws ParkingSpaceNotFoundException;
    void deleteRentalTicket(int id);
    RentalTicket getRentalTicket(int id);
    List<RentalTicket> getRentalTicketsByCustomerId(Customer customer);
    void deleteAll();
}
