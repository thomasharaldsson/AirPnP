package com.airpnp.service.implementations;

import com.airpnp.data.ParkingSpaceRepository;
import com.airpnp.data.RentalTicketRepository;
import com.airpnp.domainmodel.RentalTicket;
import com.airpnp.service.RentalTicketService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RentalTicketProductionImpl implements RentalTicketService {

    @Autowired
    private RentalTicketRepository data;

    @Override
    public List<RentalTicket> getAllRentalTickets() {
        return data.findAll();
    }

    @Override
    public void addRentalTicket(RentalTicket rentalTicket) {
        data.save(rentalTicket);
    }
}
