package com.airpnp.data;

import com.airpnp.data.exception.RentalTicketNotFoundException;
import com.airpnp.data.repository.RentalTicketRepository;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.RentalTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RentalTicketDaoImpl implements RentalTicketDao {

    @Autowired
    RentalTicketRepository data;

    @PersistenceContext
    private EntityManager em;

    private final static String JPA_QUERY_GET_RENTAL_TICKETS_FOR_CUSTOMER = "SELECT r FROM RentalTicket r WHERE r.customer =: customer";

    @Override
    public void addRentalTicket(RentalTicket newRentalTicket) {
        data.save(newRentalTicket);
    }

    @Override
    public List<RentalTicket> getAll() {
        return data.findAll();
    }

    // Get all rental tickets from this customer
    @Override
    public List<RentalTicket> getAll(Customer customer) {
        return em.createQuery(JPA_QUERY_GET_RENTAL_TICKETS_FOR_CUSTOMER).setParameter("customer", customer).getResultList();
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
