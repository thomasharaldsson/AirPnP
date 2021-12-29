package com.airpnp.service.implementations;

import com.airpnp.data.CustomerRepository;
import com.airpnp.data.exception.CustomerNotFoundException;
import com.airpnp.data.exception.UsernameAlreadyInUseException;
import com.airpnp.domainmodel.Customer;
import com.airpnp.service.CustomerService;
import com.airpnp.service.AdminService;
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
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private AdminService adminService;

    public CustomerServiceProduction() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    private void encodePassword(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
    }

    @Override
    public void addCustomer(Customer customer) throws UsernameAlreadyInUseException {
        // Check if there already exists customer or lender with this username
        if (adminService.findByUsername( customer.getUsername() ) != null || data.findByUsername( customer.getUsername() ) != null) {
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
}
