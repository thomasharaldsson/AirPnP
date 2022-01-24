package com.airpnp.data;

import com.airpnp.data.exception.RentalTicketNotFoundException;
import com.airpnp.data.exception.VehicleNotFoundException;
import com.airpnp.domainmodel.RentalTicket;

import java.util.List;

public interface RentalTicketDao {
    void addRentalTicket(RentalTicket newRentalTicket);

    List<RentalTicket> getAll();

    RentalTicket getRentalTicketById(int id) throws RentalTicketNotFoundException;

    void updateRentalTicket(RentalTicket rentalTicket) throws RentalTicketNotFoundException;

    void deleteRentalTicket(int id) throws RentalTicketNotFoundException;

    void deleteAll();
}
