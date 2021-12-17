package com.airpnp.service;

import com.airpnp.data.exception.CustomerNotFoundException;
import com.airpnp.domainmodel.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);

    void update(Customer customer) throws CustomerNotFoundException;

    Customer getCustomer(int id) throws CustomerNotFoundException;

    List<Customer> getAll();

    void deleteCustomer(int id) throws CustomerNotFoundException;

    void deleteAll();
}
