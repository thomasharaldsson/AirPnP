package com.airpnp.data;

import com.airpnp.data.exception.RentalTicketNotFoundException;
import com.airpnp.domainmodel.RentalTicket;

import java.util.List;

public class RentalTicketDaoImpl implements RentalTicketDao {
    @Override
    public void addRentalTicket(RentalTicket newRentalTicket) {
        
    }

    @Override
    public List<RentalTicket> getAll() {
        return null;
    }

    @Override
    public RentalTicket getRentalTicketById(int id) throws RentalTicketNotFoundException {
        return null;
    }

    @Override
    public void updateRentalTicket(RentalTicket rentalTicket) throws RentalTicketNotFoundException {

    }

    @Override
    public void deleteRentalTicket(int id) throws RentalTicketNotFoundException {

    }

    @Override
    public void deleteAll() {

    }
}
