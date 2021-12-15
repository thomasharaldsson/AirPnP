package com.airpnp.service.implementations;

import com.airpnp.data.CustomerRepository;
import com.airpnp.data.exception.CustomerNotFoundException;
import com.airpnp.domainmodel.Customer;
import com.airpnp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service("customerService")
public class CustomerServiceProduction implements CustomerService {

    @Autowired
    private CustomerRepository data;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void addCustomer(Customer customer) {
        // Encode the password before storing it in the database
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        data.save(customer);
    }

    @Override
    public void update(Customer customer) throws CustomerNotFoundException {
        Integer id = customer.getId();
        if (!data.existsById(id)) {
            throw new CustomerNotFoundException("Unable to update space since customer with that id=" + id + " doesn't exist");
        }
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
}
