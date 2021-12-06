package com.airpnp.service.implementations;

import com.airpnp.data.CustomerRepository;
import com.airpnp.data.exception.CustomerNotFoundException;
import com.airpnp.domainmodel.Customer;
import com.airpnp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service("customerService")
public class CustomerServiceProduction implements CustomerService {

    @Autowired
    private CustomerRepository data;

    @Override
    public void addCustomer(Customer customer) {
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
