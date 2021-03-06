package com.airpnp.service.implementations;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.airpnp.data.RentalTicketDao;
import com.airpnp.data.RentalTicketDaoImpl;
import com.airpnp.data.exception.ParkingSpaceNotFoundException;
import com.airpnp.data.repository.CustomerRepository;
import com.airpnp.data.exception.CustomerNotFoundException;
import com.airpnp.data.exception.UsernameAlreadyInUseException;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.ParkingSpace;
import com.airpnp.domainmodel.RentalTicket;
import com.airpnp.service.CustomerService;
import com.airpnp.service.ParkingSpaceService;
import com.airpnp.service.RentalTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service("customerService")
public class CustomerServiceProduction implements CustomerService {

    @Autowired
    private CustomerRepository data;

    @Autowired
    private RentalTicketService rentalTicketService;

    @Autowired
    private ParkingSpaceService parkingSpaceService;

    private final PasswordEncoder passwordEncoder;

    public CustomerServiceProduction() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    private void encodePassword(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
    }

    @Override
    public void addCustomer(Customer customer) throws UsernameAlreadyInUseException {
        // Check if there already exists customer with this username
        if (data.findByUsername( customer.getUsername() ) != null) {
            throw new UsernameAlreadyInUseException("Username " + customer.getUsername() + " is already in use. Please choose another.");
        }

        // Encode the password before storing it in the database
        encodePassword(customer);
        data.save(customer);
    }

    @Override
    public void update(Customer customer) throws CustomerNotFoundException {
        Integer id = customer.getId();
        if (!data.existsById(id)) {
            throw new CustomerNotFoundException("Unable to update space since customer with that id=" + id + " doesn't exist");
        }
        encodePassword(customer);
        data.save(customer);
    }

    @Override
    public Customer getCustomer(int id) throws CustomerNotFoundException {
        if (data.findById(id).isPresent()) {
            return data.findById(id).get();
        } else {
            throw new CustomerNotFoundException("There is no customer with id = " + id + ".");
        }
    }

    @Override
    public List<Customer> getAll() {
        return data.findAll();
    }

    @Override
    public void deleteCustomer(int id) throws CustomerNotFoundException {
        // delete parking tickets associated with this customer
        List<RentalTicket> rentalTicketsForCustomer = rentalTicketService.getRentalTicketsByCustomerId(this.getCustomer(id));

        for(RentalTicket ticket : rentalTicketsForCustomer) {
            ticket.removeParkingSpaces();
            rentalTicketService.deleteRentalTicket(ticket.getId());
        }

        // delet parkingspaces associated with this customer

        List<ParkingSpace> parkingSpacesForCustomer = parkingSpaceService.getAllParkingSpaces(this.getCustomer(id));

        for (ParkingSpace parkingSpace : parkingSpacesForCustomer) {
            try {
                parkingSpaceService.deleteParkingSpace(parkingSpace.getId());
            } catch (ParkingSpaceNotFoundException ex) {
                ex.printStackTrace();
            }

        }

        data.delete(this.getCustomer(id));
    }

    @Override
    public void deleteAll() {
        data.deleteAll();
    }

    @Override
    public Customer findByUsername(String username) {
        return data.findByUsername(username);
    }

    @Override
    public Customer findCustomerByRentalTicketId(int id) {
        Customer customer = rentalTicketService.getRentalTicket(id).getCustomer();
        return customer;
    }
}
