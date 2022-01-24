package com.airpnp.data;

import com.airpnp.data.exception.RentalTicketNotFoundException;
import com.airpnp.data.exception.VehicleNotFoundException;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.RentalTicket;
import com.airpnp.domainmodel.Vehicle;

import java.util.List;

public interface RentalTicketDao {
    void addRentalTicket(RentalTicket newRentalTicket);

    List<RentalTicket> getAll();

    List<RentalTicket> getAll(Customer customer);

    RentalTicket getRentalTicketById(int id) throws RentalTicketNotFoundException;

    void updateRentalTicket(RentalTicket rentalTicket) throws RentalTicketNotFoundException;

    void deleteRentalTicket(int id) throws RentalTicketNotFoundException;

    void deleteAll();
}
