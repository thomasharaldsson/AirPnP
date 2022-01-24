package com.airpnp.data;

import com.airpnp.data.exception.RentalTicketNotFoundException;
import com.airpnp.data.repository.RentalTicketRepository;
import com.airpnp.data.repository.VehicleRepository;
import com.airpnp.domainmodel.RentalTicket;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RentalTicketDaoImpl implements RentalTicketDao {

    @Autowired
    RentalTicketRepository data;

    @PersistenceContext
    private EntityManager em;

    private final static String JPA_QUERY_GET_RENTAL_TICKETS_FOR_CUSTOMER = "SELECT v FROM RentalTicket v WHERE v.owner =: customer";

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
