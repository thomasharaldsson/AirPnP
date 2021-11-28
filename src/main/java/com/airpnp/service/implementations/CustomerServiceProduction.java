package com.airpnp.service.implementations;

import com.airpnp.data.CustomerRepository;
import com.airpnp.data.exception.CustomerNotFoundException;
import com.airpnp.domainmodel.Customer;
import com.airpnp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Primary
@Component
public class CustomerServiceProduction implements CustomerService {

    @Autowired
    private CustomerRepository data;

    @Override
    public void addCustomer(Customer customer) {
        data.save(customer);
    }

    @Override
    public void update(Customer customer) {

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
}
